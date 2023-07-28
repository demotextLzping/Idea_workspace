package com.test.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("登录过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("登录过滤器正在过滤");
        HttpSession session=((HttpServletRequest)servletRequest).getSession();
        if(session.getAttribute("user")==null){
            ((HttpServletResponse)servletResponse).sendRedirect("login.jsp");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
        System.out.println("登录过滤器结束过滤");
        System.out.println();
    }

    @Override
    public void destroy() {
        System.out.println("登录过滤器销毁");
    }
}
