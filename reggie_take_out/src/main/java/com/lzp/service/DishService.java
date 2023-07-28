package com.lzp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzp.dto.DishDto;
import com.lzp.entity.Dish;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: LZPing
 * @date: 2022-12-11 14:42
 * @Description
 */

public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto) ;

    public DishDto getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDto dishDto);
    void deleteWithFlavor(List<Long> ids);
    void modifyStatus(List<Long> ids, Integer status);
}
