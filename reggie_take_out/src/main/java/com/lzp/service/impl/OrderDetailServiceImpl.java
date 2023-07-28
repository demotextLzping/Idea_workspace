package com.lzp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzp.entity.OrderDetail;
import com.lzp.mapper.OrderDetailMapper;
import com.lzp.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @author: LZPing
 * @date: 2022-12-09 11:10
 * @Description
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
