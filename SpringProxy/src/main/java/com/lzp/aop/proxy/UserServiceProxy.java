package com.lzp.aop.proxy;

import com.lzp.aop.proxy2.UserService;
import com.lzp.aop.proxy2.UserServiceImpl;

public class UserServiceProxy implements com.lzp.aop.proxy2.UserService {
    private final UserService userService=new UserServiceImpl();
    @Override
    public void add() throws Exception {
        check();
        userService.add();
        log();
    }

    @Override
    public void delete() throws Exception {
        check();
        userService.delete();
        log();
    }
    public void check() throws Exception {
        System.out.println("权限检查");
    }

    public void log() throws Exception {
        System.out.println("日志记录");
    }
}
