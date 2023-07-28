package com.test.control;

import com.test.entity.User;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

            HttpSession session = request.getSession();
            //传递session信息
            session.setAttribute("name",u.getName());
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
