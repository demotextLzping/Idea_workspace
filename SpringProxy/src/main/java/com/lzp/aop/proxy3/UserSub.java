package com.lzp.aop.proxy3;

public class UserSub extends UserSuper {
    @Override
    public void add() {
        System.out.println("添加对象成功");
    }
}
