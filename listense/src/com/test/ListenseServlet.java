//package com.test;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//
//@WebServlet(name = "ListenseServlet", value = "/ListenseServlet")
//public class ListenseServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        System.out.println("listense逻辑处理");
//        request.setAttribute("listense","listense");
//        request.removeAttribute("listense");
//
//        HttpSession session = request.getSession();
//        session.setAttribute("sessionListense","sessionListense");
//        session.invalidate();
//
//        response.getWriter().write("listense study");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doGet(request, response);
//    }
//}
