package com.test;

import com.entity.Address;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class elServlet2  extends HttpServlet {
/*

 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("test/html;charset=utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        request.setAttribute("aa","aaa");
        User user = new User(1, "zhangsan", new Address("hubei", "jingzhou", "jiangling"));
        User user1 = new User(2, "lisi", new Address("beijing", "beijing", "haidian"));
        //el方法传递值（通过对象传递）
        request.setAttribute("user",user);
        //el方法传递值（通过集合传递）
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        request.setAttribute("list",list);
        //el方法传递值（通过map传递）
        HashMap<String , User> map= new HashMap<>();
        map.put("user",user);
        map.put("user2",user1);
        request.setAttribute("map",map);
        request.getRequestDispatcher("el2.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
