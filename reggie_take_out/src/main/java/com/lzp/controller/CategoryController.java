package com.lzp.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzp.common.R;
import com.lzp.entity.Category;
import com.lzp.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: LZPing
 * @date: 2022-12-11 14:47
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param request
     * @param category
     * @return
     */

    @PostMapping("")
    public R<String> save(HttpServletRequest request, @RequestBody Category category) {
        log.info("category:{}", category.toString());
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    /**
     * 展示菜品分类
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize) {
        log.info("page={} pageSize={}", page, pageSize);
        //构造分页构造器
        Page<Category> pageInfo = new Page(page, pageSize);
        //构造条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();
        //添加排序条件
        queryWrapper.orderByAsc(Category::getSort);
        //执行查询
        categoryService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */

    @DeleteMapping()
    public R<String> delete(Long id) {
        log.info("删除的分类的id为:{}", id);
//        categoryService.removeById(id);
        categoryService.remove(id);
        return R.success("分类信息删除成功");
    }

    /**
     * 修改分类信息
     * @param category
     * @return
     */

    @PutMapping
    public R<String> update(@RequestBody Category category) {
        log.info(category.toString());
        //修改Catrgory的数据
        categoryService.updateById(category);
        return R.success("分类信息修改成功");
    }

    /**
     * 根据条件查询分类的数据
     * @param category
     * @return
     */
    @GetMapping("/list")
    public R<List<Category>> list(Category category){
        //添加构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(category.getType()!=null,Category::getType,category.getType());
        //添加排序条件
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> list = categoryService.list(queryWrapper);
        return  R.success(list);
    }
}
