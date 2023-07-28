package com.lzp.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author： LZPing
 * @date： 2022-11-28 09:42
 * @Description
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
//        如果登陆过，就放行
        if (null != username) {
            return true;
        }
        //没登陆过，就回到登录页面
        response.sendRedirect("login.html");
        return false;

    }
}
