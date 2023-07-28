package com.cookie.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PageServlet", value = "/PageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response，request设置编码格式
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        /*
        防止null值输出在页面上进行判断，
        如果刚代开页面值为null，将值改为 “” 输出
        如果是转发之后的值直接输出
         */
        String str=(String)request.getAttribute("str")==null?"":(String)request.getAttribute("str");

        PrintWriter writer = response.getWriter();
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<meta http-equiv='Content-Type' content='text/html'; charset='utf-8'>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<font color='red' size='10px'>"+str+"</font>");
        writer.write("<form action='login' method='get'>");
        writer.write("用户名 <input type='text' name='name' value=''><br/>");
        writer.write("密码   <input type   ='text' name='pwd' value=''><br/>");
        writer.write("<input type='submit' name='sub' value='提交'>");
        writer.write("</form");
        writer.write("</body>");
        writer.write("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
