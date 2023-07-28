package com.cookie.control;

import com.cookie.entity.User;
import com.cookie.service.UserService;
import com.cookie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response，request设置编码格式
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String name=request.getParameter("name");
        String pwd=request.getParameter("pwd");
        User user=new User(name,pwd);
        User u=userService.checkUser(user);
        System.out.println("查询结果 : "+u);
        if(u!=null){
            Cookie cookie = new Cookie("uid",u.getId()+"");
            cookie.setMaxAge(7*24*3600);
            System.out.println("LoginServlet   key  "+cookie.getName()+"    value"+cookie.getValue() );
            response.addCookie(cookie);
            response.sendRedirect("hello");
        }else {
            request.setAttribute("str","用户名或密码错误");
            request.getRequestDispatcher("page").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
