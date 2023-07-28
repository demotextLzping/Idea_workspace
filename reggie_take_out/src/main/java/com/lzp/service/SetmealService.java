package com.lzp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzp.dto.DishDto;
import com.lzp.dto.SetmealDto;
import com.lzp.entity.Setmeal;
import com.lzp.entity.SetmealDish;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.PrimitiveIterator;

/**
 * @author: LZPing
 * @date: 2022-12-11 14:42
 * @Description
 */

public interface SetmealService extends IService<Setmeal> {
    void saveWithDish(SetmealDto setmealDto);

    SetmealDto getByIdWithDish(Long id) ;

    void updateWithDish(SetmealDto setmealDto);

    void deleteWithDish(List<Long> ids);
    void modifyStatus(List<Long> ids,Integer status);
}
