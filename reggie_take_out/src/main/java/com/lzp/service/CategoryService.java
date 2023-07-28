package com.lzp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzp.entity.Category;

/**
 * @author: LZPing
 * @date: 2022-12-11 14:42
 * @Description
 */

public interface CategoryService extends IService<Category> {
    public  void  remove(Long id);
}
