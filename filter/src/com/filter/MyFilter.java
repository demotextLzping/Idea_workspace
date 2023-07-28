package com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 *      完成请求的拦截以及资源的统一管理
 *      使用方法
 *          定义普通的java类实现Filter接口
*           重写其中的方法
 *              init() 完成初始化功能    Tomcat启动时执行一次
 *              doFilter() 进行处理     每次请求都执行
 *              destory() 销毁功能      Tomcat结束时执行一次
 *          生命周期
 *              从Tomcat开始到Tomcat结束
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我是filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器正在过滤");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器过滤结束");
        System.out.println();
    }

    @Override
    public void destroy() {
        System.out.println("我是filter destroy");
    }
}
