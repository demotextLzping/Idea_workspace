package com.lzp.dao;

import com.lzp.pojo.Dept;

import java.util.List;

public interface DeptDao {

    //查询全部数据
    List<Dept> selectAll() throws Exception;

    //通过主键查找数据
    Dept selectById(int deptno) throws Exception;

    //插入数据
    int insertDept(Dept dept) throws Exception;

    //更新数据
    int updateDept(Dept dept) throws Exception;

    //删除数据
    int deleteDept(int deptno ) throws Exception;
}
