package com.lzp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzp.entity.Orders;


/**
 * @author: LZPing
 * @date: 2022-12-11 14:42
 * @Description
 */

public interface OrderService extends IService<Orders> {
      void submit(Orders orders);
}
