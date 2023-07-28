package com.testservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLife", value = "/ServletLife")
public class ServletLife extends HttpServlet {


    /**
     * 完成servlet的对象的初始化操作
     * 在servlet接收到第一次请求的时候被创建对象
     * 生命周期：从第一次接收请求开始到服务器关闭之后销毁
     * 当在web.xml文件中配置了 <load-on-startup>1</load-on-startup>,并开启tomcat的时候就会创建servlet对象，中间的数值代表优先级的意思
     * @throws ServletException
     */

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<h1>servlet life</h1>");
        System.out.println("learn servlet life");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
