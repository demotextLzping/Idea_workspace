package com.test;

import com.entity.Address;
import com.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "elServlet", value = "/elServlet")
public class elServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("test/html;charset=utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);
        request.setAttribute("aa","aaa");
        User user = new User(1, "zhangsan", new Address("hubei", "jingzhou", "jiangling"));
        User user1 = new User(2, "lisi", new Address("beijing", "beijing", "haidian"));
        //传统方法传递值（通过对象传递）
        request.setAttribute("user",user);
        //传统方法传递值（通过集合传递）
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        request.setAttribute("list",list);
        //传统方法传递值（通过map传递）
        HashMap<String , User> map= new HashMap<>();
        map.put("user",user);
        map.put("user2",user1);
        request.setAttribute("map",map);
        request.getRequestDispatcher("el.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
