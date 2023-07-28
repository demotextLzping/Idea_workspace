package com.lzp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzp.mapper.EmployeeMapper;
import com.lzp.pojo.Employee;
import com.lzp.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author: LZPing
 * @date: 2022-12-09 11:10
 * @Description
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
