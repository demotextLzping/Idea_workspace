package com.lzp.controller;

import com.lzp.pojo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： LZPing
 * @date： 2022-11-28 09:40
 * @Description
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(String username, HttpServletRequest request) {
        if (null != username && !"".equals(username)) {
            request.getSession().setAttribute("username", username);
            return "main";
        }
        return "redirect:/login.html";
    }
}
