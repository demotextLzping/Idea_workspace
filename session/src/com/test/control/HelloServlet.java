package com.test.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        //response，request设置编码格式
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //接收session信息
        HttpSession session = request.getSession();
        String  name =(String) session.getAttribute("name");

//        String name=request.getParameter("name");
        PrintWriter writer = response.getWriter();
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<meta http-equiv='Content-Type' content='text/html'; charset='utf-8'>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<font color='red' size='10px'>欢迎 "+name+" 登录</font>");
        writer.write("</form");
        writer.write("</body>");
        writer.write("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
