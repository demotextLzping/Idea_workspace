//package com.listense;
//
//import javax.servlet.*;
//import java.util.Date;
//
///**
// * 主要的三种作用域
// *      ServletContext(application) session request
// *      request
// *          接口
// *          ServletRequestListener 监听request对象的创建和销毁
// *               public void requestDestroyed(ServletRequestEvent sre)
// *               public void requestInitialized(ServletRequestEvent sre)
// *          ServletRequestAttributeListener 监听request对象的作用域的属性的添加删除和修改
// *               public void attributeAdded(ServletRequestAttributeEvent srae)
// *               public void attributeRemoved(ServletRequestAttributeEvent srae)
// *               public void attributeReplaced(ServletRequestAttributeEvent srae)
// */
//public class MyListense implements ServletRequestListener, ServletRequestAttributeListener {
//    @Override
//    public void requestDestroyed(ServletRequestEvent sre) {
//        System.out.println("request对象被销毁");
//    }
//
//    @Override
//    public void requestInitialized(ServletRequestEvent sre) {
//        System.out.println("request对象被创建");
//    }
//    @Override
//    public void attributeAdded(ServletRequestAttributeEvent srae) {
//        System.out.println("request作用域添加数据");
//        System.out.println(srae.getName());
//        System.out.println(srae.getValue());
//
//    }
//    @Override
//    public void attributeRemoved(ServletRequestAttributeEvent srae) {
//        System.out.println("request作用域移除数据");
//        System.out.println(srae.getName());
//        System.out.println(srae.getValue());
//    }
//    @Override
//    public void attributeReplaced(ServletRequestAttributeEvent srae) {
//        System.out.println("request作用域修改数据");
//        System.out.println(srae.getName());
//        System.out.println(srae.getValue());
//    }
//
//}
