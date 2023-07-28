package com.lzp.test;

import com.lzp.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FactoryBeanTest {
    @Test
    public void test() {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("application2.xml");
        User user = (User) appCon.getBean("user");
        System.out.println(user);
    }

}
