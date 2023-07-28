package com.work;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class WebListense implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("count",-1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servletContext被销毁");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        int count =(int) servletContext.getAttribute("count");
        ++count;
        servletContext.setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        int count =(int) servletContext.getAttribute("count");
        --count;
        servletContext.setAttribute("count",--count);
    }
}
