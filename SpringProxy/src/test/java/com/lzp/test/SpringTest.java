package com.lzp.test;

import com.lzp.aop.SpringAspectj.Advice;
import com.lzp.aop.proxy2.*;
import com.lzp.aop.proxy.UserServiceProxy;
import com.lzp.aop.proxy3.CGLIBProxy;
import com.lzp.aop.proxy3.UserSub;
import com.lzp.aop.proxy3.UserSuper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;


public class SpringTest {
    @Test
    public void test() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) app.getBean("usi");
        userService.add();
        userService.delete();
    }

    @Test
    public void test2() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceProxy userServiceProxy= (UserServiceProxy) app.getBean("proxy");
        userServiceProxy.add();
        userServiceProxy.delete();
    }

    @Test
    public void test3() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDKProxy jdkProxy=(JDKProxy) app.getBean("jdkproxy");
        UserService userService = (UserService) jdkProxy.createProxyInstance(new UserServiceImpl());
        userService.add();
        userService.delete();
        System.out.println("=============");
        StudentService studentService =(StudentService) jdkProxy.createProxyInstance(new StudentServiceImpl());
        studentService.add();
    }

    @Test
    public void test4() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        CGLIBProxy cglib = (CGLIBProxy) app.getBean("cglib");
        UserSuper userSuper = (UserSuper) cglib.createProxyInstance(new UserSub());
        userSuper.add();
    }

    @Test
    public void test5() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationSpringXml.xml");
        com.lzp.aop.SpringXML.UserService userService=(com.lzp.aop.SpringXML.UserService) app.getBean("userServiceImpl");
        userService.add();
        userService.delete();

    }
//    ioc注解方式实现
    @Test
    public void test6() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationSpringAspectj.xml");
        //规则 @Service 注解：如果没有明确设置id值，那么默认的id值是 类名首字母小写
        com.lzp.aop. SpringAspectj.UserService userService=(com.lzp.aop.SpringAspectj.UserService) app.getBean("userServiceImpl");
        userService.add();
        userService.delete();
    }
}
