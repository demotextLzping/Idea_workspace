package com.lzp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzp.entity.ShoppingCart;
import com.lzp.entity.User;
import com.lzp.mapper.ShoppingCartMapper;
import com.lzp.mapper.UserMapper;
import com.lzp.service.ShoppingCartService;
import com.lzp.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: LZPing
 * @date: 2022-12-09 11:10
 * @Description
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
