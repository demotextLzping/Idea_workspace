package com.lzp.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzp.common.CustomException;
import com.lzp.mapper.CategoryMapper;
import com.lzp.entity.Category;
import com.lzp.entity.Dish;
import com.lzp.entity.Setmeal;
import com.lzp.service.CategoryService;
import com.lzp.service.DishService;
//import com.sun.deploy.net.proxy.RemoveCommentReader;
import com.lzp.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: LZPing
 * @date: 2022-12-11 14:43
 * @Description
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Autowired
    private DishService dishService;


    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        //查询当前分类是否关联了菜品，如果已经关联了菜品，抛出一个业务异常
        int dishCount = dishService.count(dishLambdaQueryWrapper);
        if (dishCount > 0) {
            throw new CustomException("当前分类关联了菜品，无法删除");
        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        //查询当前分类是否关联了套餐，如果已经关联了菜品，抛出一个业务异常
        int setMealCount = setmealService.count(setmealLambdaQueryWrapper);
        if (setMealCount > 0) {
            throw new CustomException("当前分类关联了套餐，无法删除");
        }
        super.removeById(id);


    }
}
