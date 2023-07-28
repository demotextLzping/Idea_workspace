package com.lzp.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzp.dto.DishDto;
import com.lzp.dto.SetmealDto;
import com.lzp.entity.*;
import com.lzp.service.CategoryService;
import com.lzp.service.SetmealDishService;
import com.lzp.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import com.lzp.common.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: LZPing
 * @date: 2022-12-14 12:19
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    @Autowired
    private SetmealDishService setmealDishService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public R<String> save(@RequestBody SetmealDto setmealDto) {
        log.info("套餐信息 {}", setmealDto);
        setmealService.saveWithDish(setmealDto);
        return R.success("新增套餐成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page={} pageSize={} name={}", page, pageSize, name);
        //构造分页构造器
        Page<Setmeal> pageInfo = new Page<>(page, pageSize);
        //构造SetmealDto
        Page<SetmealDto> SetmealDtoPage = new Page<>();
        //构造条件构造器
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Setmeal::getName, name);
        //添加排序条件
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
//        //执行查询
        setmealService.page(pageInfo, queryWrapper);
        //将pageInfo的全部数据除了records全部替换到dishDtoPage里
        BeanUtils.copyProperties(pageInfo, SetmealDtoPage, "records");
//        //获取pageInfo 的全部数据
        List<Setmeal> records = pageInfo.getRecords();

        List<SetmealDto> list = records.stream().map((item) -> {
            //创建一个DishDto对象
            SetmealDto setmealDto = new SetmealDto();
            //循环遍历每个item将查询到的分类的名称写入对应的disDto中
            BeanUtils.copyProperties(item, setmealDto);
            Long categoryId = item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            //数据的修改可能会造成数据空指针异常
            if (category != null) {
                String categoryName = category.getName();
                setmealDto.setCategoryName(categoryName);
            }
            return setmealDto;
        }).collect(Collectors.toList());
        //设置records的值
        SetmealDtoPage.setRecords(list);
        return R.success(SetmealDtoPage);
    }

    /**
     * 分页套餐信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<SetmealDto> getByIdWithDish(@PathVariable Long id) {
        log.info("套餐信息id :{}", id);
        SetmealDto setmealDto = setmealService.getByIdWithDish(id);
        return R.success(setmealDto);
    }

    /**
     * 获取套餐菜品
     * @param id
     * @return
     */
    @GetMapping("dish/{id}")
    public R<SetmealDto> getByIdWithDishes(@PathVariable Long id) {
        log.info("套餐信息id :{}", id);
        SetmealDto setmealDto = setmealService.getByIdWithDish(id);
        return R.success(setmealDto);
    }


    /**
     * 修改套餐的信息
     *
     * @param setmealDto
     * @param lambdaUpdateWrapper
     * @return
     */
    @PutMapping("")
    public R<String> update(@RequestBody SetmealDto setmealDto, LambdaUpdateWrapper<Setmeal> lambdaUpdateWrapper) {
        log.info("套餐修改:{}", setmealDto.toString());
        setmealService.updateWithDish(setmealDto);
        return R.success("修改套餐信息成功");
    }

    /**
     * 删除套餐
     *
     * @param ids
     * @return
     */
    @DeleteMapping()
    public R<String> delete(@RequestParam List<Long> ids) {
        log.info("删除的套餐的id为:{}", ids);
        setmealService.deleteWithDish(ids);
        return R.success("套餐信息删除成功");
    }

    @PostMapping("/status//{status}")
    @Transactional
    public R<String> modifyStatusStop(@PathVariable Integer status,@RequestParam List<Long> ids) {
        log.info("修改状态的id:{}", ids);
        setmealService.modifyStatus(ids, status);
        return R.success("状态停售修改成功");
    }



    @GetMapping("/list")
    public R<List<Setmeal>> list(Setmeal setmeal) {
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(setmeal.getCategoryId() != null, Setmeal::getCategoryId, setmeal.getCategoryId());
        //添加条件 ，查询状态为1的菜品
        queryWrapper.eq(Setmeal::getStatus, 1);
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
        List<Setmeal> list = setmealService.list(queryWrapper);
        return R.success(list);
    }
//
//    @GetMapping("/list")
//    public R<List<SetmealDto>> list(Setmeal setmeal) {
//        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(setmeal.getCategoryId() != null, Setmeal::getCategoryId, setmeal.getCategoryId());
//        //添加条件 ，查询状态为1的菜品
//        queryWrapper.eq(Setmeal::getStatus, 1);
//        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
//        List<Setmeal> list = setmealService.list(queryWrapper);
//        List<SetmealDto> setmealDtoList = list.stream().map((item) -> {
//            //创建一个setmealDto对象
//            SetmealDto setmealDto = new SetmealDto();
//            //循环遍历每个item将查询到的分类的名称写入对应的setmealDto中
//            BeanUtils.copyProperties(item, setmealDto);
//            Long categoryId = item.getCategoryId();
//            Category category = categoryService.getById(categoryId);
//            //数据的修改可能会造成数据空指针异常
//            if (category != null) {
//                String categoryName = category.getName();
//                setmealDto.setCategoryName(categoryName);
//            }
//            Long setmealId = item.getId();
//            LambdaQueryWrapper<SetmealDish> dishQueryWrapper = new LambdaQueryWrapper<>();
//            dishQueryWrapper.eq(SetmealDish::getSetmealId, setmealId);
//            List<SetmealDish> setmealDishes = setmealDishService.list(dishQueryWrapper);
//            setmealDto.setSetmealDishes(setmealDishes);
//            return setmealDto;
//        }).collect(Collectors.toList());
//        return R.success(setmealDtoList );
//    }


}
