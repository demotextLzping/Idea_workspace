package com.lzp.aop.proxy;

public class UserServiceImpl implements UserService {
    @Override
    public void add() throws Exception {
        System.out.println("添加User成功");
    }

    @Override
    public void delete() throws Exception {
        System.out.println("删除User成功");
    }

}
