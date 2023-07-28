package com.lzp.controller;

/**
 * @author: LZPing
 * @date: 2022-12-12 14:42
 * @Description
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzp.common.R;
import com.lzp.dto.DishDto;
import com.lzp.entity.Category;
import com.lzp.entity.Dish;
import com.lzp.entity.DishFlavor;
import com.lzp.service.CategoryService;
import com.lzp.service.DishFlavorService;
import com.lzp.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜品管理
 */
@RestController
@Slf4j
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private DishFlavorService dishFlavorService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto) {
        log.info("菜品保存:{}", dishDto.toString());

        dishService.saveWithFlavor(dishDto);

        return R.success("新增菜品成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page={} pageSize={} name={}", page, pageSize, name);
        //构造分页构造器
        Page<Dish> pageInfo = new Page<>(page, pageSize);
        //构造DishDto
        Page<DishDto> dishDtoPage = new Page<>();
        //构造条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Dish::getName, name);
        //添加排序条件
        queryWrapper.orderByDesc(Dish::getUpdateTime);
        //执行查询
        dishService.page(pageInfo, queryWrapper);
        //将pageInfo的全部数据除了records全部替换到dishDtoPage里
        BeanUtils.copyProperties(pageInfo, dishDtoPage, "records");
        //获取pageInfo 的全部数据
        List<Dish> records = pageInfo.getRecords();

        List<DishDto> list = records.stream().map((item) -> {
            //创建一个DishDto对象
            DishDto dishDto = new DishDto();

            //循环遍历每个item将查询到的分类的名称写入对应的disDto中
            BeanUtils.copyProperties(item, dishDto);
            Long categoryId = item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            //数据的修改可能会造成数据空指针异常
            if (category != null) {
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            return dishDto;
        }).collect(Collectors.toList());

        //设置records的值
        dishDtoPage.setRecords(list);
        return R.success(dishDtoPage);
    }

    /**
     * 根据id查询分类和全部信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<DishDto> get(@PathVariable Long id) {
        log.info("菜品信息id :{}", id);
        DishDto dishDto = dishService.getByIdWithFlavor(id);
        return R.success(dishDto);
    }

    /**
     * 修改菜品的信息
     *
     * @param dishDto
     * @return
     */
    @PutMapping("")
    public R<String> update(@RequestBody DishDto dishDto) {
        log.info("菜品修改:{}", dishDto.toString());
        dishService.updateWithFlavor(dishDto);
        return R.success("修改菜品信息成功");
    }

    @DeleteMapping()
    public R<String> delete(@RequestParam List<Long> ids) {
        log.info("删除的菜品的id为:{}", ids);
        dishService.deleteWithFlavor(ids);
        return R.success("菜品信息删除成功");
    }

    /**
     * 根据条件查询菜品
     *
     * @param dish
     * @return
     */
//    @GetMapping("/list")
//    public R<List<Dish>> list(Dish dish) {
//        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
//        //添加条件 ，查询状态为1的菜品
//        queryWrapper.eq(Dish::getStatus, 1);
//        queryWrapper.orderByDesc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
//        List<Dish> list = dishService.list(queryWrapper);
//        return R.success(list);
//    }

    @GetMapping("/list")
    public R<List<DishDto>> list(Dish dish) {
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
        //添加条件 ，查询状态为1的菜品
        queryWrapper.eq(Dish::getStatus, 1);
        queryWrapper.orderByDesc(Dish::getSort).orderByDesc(Dish::getUpdateTime);

        List<Dish> list = dishService.list(queryWrapper);
        List<DishDto> disDtoList = list.stream().map((item) -> {
            //创建一个DishDto对象
            DishDto dishDto = new DishDto();
            //循环遍历每个item将查询到的分类的名称写入对应的disDto中
            BeanUtils.copyProperties(item, dishDto);
            Long categoryId = item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            //数据的修改可能会造成数据空指针异常
            if (category != null) {
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            Long dishId = item.getId();
            LambdaQueryWrapper<DishFlavor> dishQueryWrapper = new LambdaQueryWrapper<>();
            dishQueryWrapper.eq(DishFlavor::getDishId,dishId);
            List<DishFlavor> dishFlavorList = dishFlavorService.list(dishQueryWrapper);
            dishDto.setFlavors(dishFlavorList);
            return dishDto;
        }).collect(Collectors.toList());
        return R.success(disDtoList);
    }
    @PostMapping("/status/{status}")
    @Transactional
    public R<String> modifyStatusStop(@PathVariable Integer status,@RequestParam List<Long> ids) {
        log.info("修改状态的id:{}", ids);
        dishService.modifyStatus(ids, status);
        return R.success("状态停售修改成功");
    }



}
