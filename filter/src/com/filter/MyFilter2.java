package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我是第二个过滤器的初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("第二个过滤器正在过滤");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("第二个过滤器结束过滤");
    }

    @Override
    public void destroy() {
        System.out.println("我是第二个过滤的销毁");
    }
}
