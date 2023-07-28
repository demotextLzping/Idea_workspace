package com.lzp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzp.entity.Orders;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author: LZPing
 * @date: 2022-12-11 14:42
 * @Description
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}
