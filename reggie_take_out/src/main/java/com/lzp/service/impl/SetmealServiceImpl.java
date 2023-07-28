package com.lzp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzp.common.CustomException;
import com.lzp.common.R;
import com.lzp.dto.DishDto;
import com.lzp.dto.SetmealDto;
import com.lzp.entity.Dish;
import com.lzp.entity.DishFlavor;
import com.lzp.entity.Setmeal;
import com.lzp.entity.SetmealDish;
import com.lzp.mapper.SetmealDishMapper;
import com.lzp.mapper.SetmealMapper;
import com.lzp.service.SetmealDishService;
import com.lzp.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: LZPing
 * @date: 2022-12-09 11:10
 * @Description
 */
@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
    @Autowired
    private SetmealDishService setmealDishService;

    @Transactional
    @Override
    public void saveWithDish(SetmealDto setmealDto) {
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item) -> {
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());
        setmealDishService.saveBatch(setmealDishes);
    }

    @Override
    public SetmealDto getByIdWithDish(Long id) {
        //查询菜品的基本信息
        Setmeal setmeal = this.getById(id);
        SetmealDto setmealDto= new SetmealDto();
        //将dish的全部数据填充到SetmealDto中
        BeanUtils.copyProperties(setmeal, setmealDto);
        //查询菜品对应的口味信息，填充口味信息到dishDto中
        LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getDishId, setmeal.getId());
        List<SetmealDish> dishes = setmealDishService.list(queryWrapper);
        setmealDto.setSetmealDishes(dishes);
        return setmealDto;
    }

    @Override
    @Transactional
    public void updateWithDish(SetmealDto setmealDto) {
        //更新菜品表
        this.updateById(setmealDto);
        //更新口味表
        //删除全部的数据
        LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId, setmealDto.getId());
        setmealDishService.remove(queryWrapper);
        //再插入新的数据
        List<SetmealDish> dishes = setmealDto.getSetmealDishes();

        dishes = dishes.stream().map((item) -> {
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());
        //保存菜品口味数据到菜品口味表dish_flavor
        setmealDishService.saveBatch(dishes);
    }

    @Transactional
    @Override
    public void deleteWithDish(List<Long> ids) {
        //查询套餐状态，确定是否能删除
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId, ids);
        queryWrapper.eq(Setmeal::getStatus,1);
        int count=this.count(queryWrapper);
        if(count>0){
            throw   new CustomException("套餐正在售卖中，不能删除");
        }
        this.removeByIds(ids);

        //删除关系表中的数据
        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(SetmealDish::getSetmealId, ids);
        setmealDishService.remove(lambdaQueryWrapper);
    }

    @Transactional
    @Override
    public void modifyStatus(List<Long> ids, Integer status) {
        log.info("修改状态的id:{}", ids);
        LambdaUpdateWrapper<Setmeal> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.in(Setmeal::getId, ids)
                .set(Setmeal::getStatus,status);
        this.update(queryWrapper);
    }


}
