package com.lzp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzp.common.CustomException;
import com.lzp.dto.DishDto;
import com.lzp.entity.Setmeal;
import com.lzp.entity.SetmealDish;
import com.lzp.mapper.DishMapper;
import com.lzp.entity.Dish;
import com.lzp.entity.DishFlavor;
import com.lzp.service.DishFlavorService;
import com.lzp.service.DishService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: LZPing
 * @date: 2022-12-09 11:10
 * @Description
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * 新增菜品，保存对应的口味的id
     *
     * @param dishDto
     */
    @Transactional
    @Override
    public void saveWithFlavor(DishDto dishDto) {
        //先保存菜品的基本信息
        this.save(dishDto);
        //获取菜品的id
        Long dishId = dishDto.getId();
        //菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());
        //保存菜品口味数据到菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);
    }

    @Override
    public DishDto getByIdWithFlavor(Long id) {
        //查询菜品的基本信息
        Dish dish = this.getById(id);
        DishDto dishDto = new DishDto();
        //将dish的全部数据填充到ddishDto中
        BeanUtils.copyProperties(dish, dishDto);
        //查询菜品对应的口味信息，填充口味信息到dishDto中
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(queryWrapper);
        dishDto.setFlavors(flavors);

        return dishDto;


    }

    @Override
    @Transactional
    public void updateWithFlavor(DishDto dishDto) {
        //更新菜品表
        this.updateById(dishDto);
        //更新口味表
        //删除全部的数据
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dishDto.getId());
        dishFlavorService.remove(queryWrapper);
        //再插入新的数据
        List<DishFlavor> flavors = dishDto.getFlavors();

        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());
        //保存菜品口味数据到菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);


    }

    @Override
    @Transactional
    public void deleteWithFlavor(List<Long> ids) {
        //查询套餐状态，确定是否能删除
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Dish::getId, ids);
        queryWrapper.eq(Dish::getStatus,1);
        int count=this.count(queryWrapper);
        if(count>0){
            throw  new CustomException("菜品正在售卖中，不能删除");
        }
        this.removeByIds(ids);
        //删除关系表中的数据
        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(DishFlavor::getDishId, ids);
        dishFlavorService.remove(lambdaQueryWrapper);
    }

    @Transactional
    @Override
    public void modifyStatus(List<Long> ids, Integer status) {
        log.info("修改状态的id:{}", ids);
        LambdaUpdateWrapper<Dish> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.in(Dish::getId, ids)
                .set(Dish::getStatus,status);
        this.update(queryWrapper);
    }
}
