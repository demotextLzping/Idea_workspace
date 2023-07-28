package com.lzp.mapper;

import com.lzp.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> selectAllEmp() throws Exception;
}