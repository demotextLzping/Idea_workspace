package com.lzp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzp.entity.ShoppingCart;
import com.lzp.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: LZPing
 * @date: 2022-12-09 11:09
 * @Description
 */
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
