package com.testservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestServlet", value = "/RequestServlet")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get请求");
        //请求行
        System.out.println("请求行 : ");
        //获取请求方式
        String method=request.getMethod();
        System.out.println(method);
        //获取请求的完整地址
        StringBuffer url = request.getRequestURL();
        System.out.println(url);
        //获取请求中的资源路径
        String uri = request.getRequestURI();
        System.out.println(uri);
        //获取请求中的协议
        String scheme = request.getScheme();
        System.out.println(scheme);

        //请求头
        System.out.println("请求头: ");
        String host=request.getHeader("host");
        System.out.println("host"+": "+host);
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key=headerNames.nextElement();
            String value=request.getHeader(key);
            System.out.println(key+":"+value);
        }

        //获取用户请求数据，无论请求方式时get还是post获取方式一样
        System.out.println("请求数据: ");
        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        String fav=request.getParameter("fav");
        System.out.println(name+" "+pwd+" "+fav);

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String key=parameterNames.nextElement();
            String value=request.getHeader(key);
            System.out.println(key+" "+value);
        }
        //获取相同key的多个数据值，例如checkbox多选框
        String[] parameterValues = request.getParameterValues("fav");
        for (String parameterValue : parameterValues) {
            System.out.println("fav "+parameterValue);
        }

        //其他方法
        System.out.println("获取客户端的ip地址: "+request.getRemoteAddr());
        System.out.println("获取客户端的完整主机名: "+request.getRemoteHost());
        System.out.println("获取客户端的网络端口号: "+request.getRemotePort());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post请求");
        this.doGet(request,response);

    }
}
