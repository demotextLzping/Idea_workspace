package com.cookie.control;

import com.cookie.entity.User;
import com.cookie.service.UserService;
import com.cookie.service.impl.UserServiceImpl;
import com.test.CookieServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieProjectServlet", value = "/CookieProjectServlet")
public class CookieProjectServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                String key=cookie.getName();
                if("uid".equals(key)){
                    String value=cookie.getValue();
                    System.out.println(" CookieProjectServlet key :        "+key+"     value :       "+value);
                    User userById = userService.getUserById(Integer.valueOf(value));
                    System.out.println("userById  :  "+userById);
                    if(userById !=null){
                        response.sendRedirect("hello");
                    }
                    else {
//                        使用重定向无法跳转，使用请求装法可以条状到page页面
//                        response.sendRedirect("page");
                        request.getRequestDispatcher("page");
                    }
                }else {
                    response.sendRedirect("page");
                    request.getRequestDispatcher("page");
                }
            }
        }else{
//            response.sendRedirect("page");
            request.getRequestDispatcher("page");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
