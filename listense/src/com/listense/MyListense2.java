//package com.listense;
//
//import javax.servlet.ServletContextAttributeEvent;
//import javax.servlet.ServletContextAttributeListener;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//public class MyListense2 implements ServletContextListener, ServletContextAttributeListener {
//    //对象的创建和销毁
//    public void contextInitialized(ServletContextEvent sce) {
//        System.out.println("context对象被创建");
//    }
//
//    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("context对象被销毁");
//    }
//
//    //属性的添加删除和修改
//    public void attributeAdded(ServletContextAttributeEvent scae) {
//        System.out.println("context作用域被添加");
//        System.out.println(scae.getName());
//        System.out.println(scae.getValue());
//    }
//
//    public void attributeRemoved(ServletContextAttributeEvent scae) {
//        System.out.println("context作用域被移除");
//        System.out.println(scae.getName());
//        System.out.println(scae.getValue());
//    }
//
//    public void attributeReplaced(ServletContextAttributeEvent scae) {
//        System.out.println("context作用域被修改");
//        System.out.println(scae.getName());
//        System.out.println(scae.getValue());
//    }
//}
