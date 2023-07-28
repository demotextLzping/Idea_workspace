package com.lzp.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzp.common.BaseContext;
import com.lzp.common.R;
import com.lzp.dto.DishDto;
import com.lzp.dto.OrdersDto;
import com.lzp.entity.*;
import com.lzp.service.OrderService;
import com.lzp.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: LZPing
 * @date: 2022-12-16 14:28
 * @Description
 */
@Slf4j
@RequestMapping("order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        log.info("订单数据:{}", orders);
        orderService.submit(orders);
        return R.success("下单成功");
    }

//    @GetMapping("/userPage")
//    public R<Page> page(int page, int pageSize) {
//
//        return null;
//    }

}
