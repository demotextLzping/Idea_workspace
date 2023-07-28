package com.lzp.servlet;

import com.google.gson.Gson;
import com.lzp.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @author： LZPing
 * @date： 2022-11-18 10:55
 * @Description
 */
@WebServlet("/testServlet.do")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User("张三", 22, "男", new Date());

        //响应普通文本数据
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Gson gson = new Gson();
        String str = gson.toJson(user);
        System.out.println(str);
        resp.getWriter().print(str);
    }
}
