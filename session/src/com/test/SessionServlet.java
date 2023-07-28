package com.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SessionServlet", value = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("接收到请求");
        HttpSession session = request.getSession();
        //通过getId获得JSESSIONID
        System.out.println(new SimpleDateFormat("HH -mm -ss ").format(new Date())+"   getId : "+session.getId());
        //修改session会话的时间
//        session.setMaxInactiveInterval(5);
        //设置session强制失效 每次的session对象都是新的
//        session.invalidate();

        //发送session对象
        session.setAttribute("100","zhangsan");
        response.getWriter().write("学习Session");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
