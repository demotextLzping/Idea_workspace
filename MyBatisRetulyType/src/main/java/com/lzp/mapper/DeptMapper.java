package com.lzp.mapper;

import com.lzp.pojo.Dept;

public interface DeptMapper {

    Dept findDeptById(int deptno) throws Exception;
}