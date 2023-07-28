package com.lzp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzp.entity.Employee;
import com.lzp.entity.User;
import com.lzp.mapper.EmployeeMapper;
import com.lzp.mapper.UserMapper;
import com.lzp.service.EmployeeService;
import com.lzp.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: LZPing
 * @date: 2022-12-09 11:10
 * @Description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
