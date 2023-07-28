package com.lzp.aop.proxy2;

public class StudentServiceImpl implements StudentService {
    @Override
    public void add() throws Exception {
        System.out.println("学生添加成功");
    }
}
