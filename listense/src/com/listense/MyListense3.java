//package com.listense;
//
//import javax.servlet.http.*;
//
//public class MyListense3 implements HttpSessionListener, HttpSessionAttributeListener {
//    public void sessionCreated(HttpSessionEvent se) {
//        System.out.println("session对象被创建");
//    }
//
//    public void sessionDestroyed(HttpSessionEvent se) {
//        System.out.println("session对象被销毁");
//    }
//
//    public void attributeAdded(HttpSessionBindingEvent se) {
//        System.out.println("session作用域被添加");
//        System.out.println(se.getName());
//        System.out.println(se.getValue());
//    }
//
//    public void attributeRemoved(HttpSessionBindingEvent se) {
//        System.out.println("session作用域被删除");
//        System.out.println(se.getName());
//        System.out.println(se.getValue());
//    }
//
//    public void attributeReplaced(HttpSessionBindingEvent se) {
//        System.out.println("session作用域被修改");
//        System.out.println(se.getName());
//        System.out.println(se.getValue());
//    }
//}
