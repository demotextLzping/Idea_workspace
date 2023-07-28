package com.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * cookie用来处理客户端发送的不同请求的时候是哟美好相同的参数信息
 * cookie的使用
 *         Cookie cookie = new Cookie("0001","beijing");
 *         response.addCookie(cookie);
 *         //设置固定路径
 *         cookie2.setPath("/ck");
 *         //获取cookie
 *         Cookie[] cookies = request.getCookies();
 *         if(cookies.length>0){
 *             for (Cookie c : cookies) {
 *                 String key=c.getName();
 *                 String value=c.getValue();
 *                 System.out.println("key : "+key+" "+"value : "+value);
 *             }
 *
 *         }
 * 特点：
 *      1.cookie时保存在游览器的数据名称
 *      2.cookie分类：临时cookie : 默认在内存中，当游览器关闭时，cookie失效
 *                   持久化cookie : 保存在游览器的某个存储目录中，当时间过期后，才会失效
 *
 */

@WebServlet(name = "CookieServlet", value = "/CookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        //设置cookie（可以存在相同的键）
        Cookie cookie = new Cookie("0001","beijing");
        Cookie cookie2 = new Cookie("0002","shanghai");
        //设置有效时间
        cookie.setMaxAge(3*24*3600);
        cookie2.setMaxAge(3*24*3600);
        //设置固定路径
        cookie2.setPath("/ck");
        response.addCookie(cookie);
        response.addCookie(cookie2);

        response.getWriter().write("学习cookie");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
