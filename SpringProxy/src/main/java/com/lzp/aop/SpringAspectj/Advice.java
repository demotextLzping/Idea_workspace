package com.lzp.aop.SpringAspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Aspect
@Component
public class Advice {
    @Before("execution(* com.lzp.aop.SpringAspectj.UserServiceImpl.*(..))")
    public void check() throws Exception {
        System.out.println("权限检查");
    }

    @After("execution(* com.lzp.aop.SpringAspectj.UserServiceImpl.*(..))")
    public void log() throws Exception {
        System.out.println("日志记录");
    }
}
