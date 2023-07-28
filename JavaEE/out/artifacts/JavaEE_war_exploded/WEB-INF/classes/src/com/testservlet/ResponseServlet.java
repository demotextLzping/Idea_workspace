package com.testservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResponseServlet", value = "/ResponseServlet")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应头
        //存在相同的key时会覆盖
        response.setHeader("hhh","xxx");
        response.setHeader("hhh","zzz");
        //存在相同的key时不会覆盖
        response.addHeader("中国","上海");
        response.addHeader("中国","北京");

        //响应行
        //设置响应状态码
        response.sendError(404,"not found");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        //服务端放回的数据按照一定的格式进行渲染
        response.setHeader("Content-Type","text/html");//设置喧嚷为html
//        response.setContentType("text/plain");//设置喧嚷为纯文本
        response.getWriter().write("<h1>java is easy</h1>");
        //响应体



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
