package com.lzp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzp.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: LZPing
 * @date: 2022-12-09 11:09
 * @Description
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
