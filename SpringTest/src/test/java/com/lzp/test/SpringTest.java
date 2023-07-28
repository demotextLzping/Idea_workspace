package com.lzp.test;

import com.lzp.pojo.Student;
import com.lzp.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;


public class SpringTest {
    @Test
    public void test() {
        ApplicationContext appCon = new ClassPathXmlApplicationContext(new String[]{"Spring-bean1.xml", "Spring-bean2.xml"});
        User user = (User) appCon.getBean("us6");
        System.out.println(user);
    }

    @Test
    public void test2() {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student stu = (Student) appCon.getBean("stu");
        System.out.println(stu);
//        Student stu2 = (Student) appCon.getBean("stu");
//        System.out.println(stu == stu2);

    }

    @Test
    public void test3() {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContextDI.xml");
        Student student = (Student) appCon.getBean("student");
        System.out.println(student);
//        String userName = student.getPro().getProperty("userName");
//        String passWord = student.getPro().getProperty("passWord");
//        System.out.println(student + " " + userName + " " + passWord);
    }

    @Test
    @Autowired
    public void test4() {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContextDI.xml");
        Student student = (Student) appCon.getBean("stuAutoWire");
        System.out.println(student);
    }

    @Test
    public void test5() {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User us1 = (User) appCon.getBean("us5");
//        System.out.println(us1);
        User us2 = appCon.getBean("us6", User.class);
        System.out.println(us2);
    }

    @Test
    public void test6() {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
        User us1 = (User) appCon.getBean("us7");
        System.out.println(us1);
    }

    @Test
    public void test7() {
        ClassPathXmlApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student stu = appCon.getBean("stu", Student.class);
        System.out.println(stu);
        appCon.close();
    }
}
