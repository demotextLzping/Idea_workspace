package com.lzp.controller;

import com.lzp.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LZPing
 * @date: 2022-12-05 10:32
 * @Description
 */

@Controller
public class demoController {
    @RequestMapping("/demo")
    @ResponseBody

    public String demo(String Param) {
        return Param + "abc";
    }

    @RequestMapping("/demo2")
    @ResponseBody
    public User demo2(User user) {
        return user;
    }

    @RequestMapping("/demo3")
    @ResponseBody
    public List<User> demoList() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "zhansan"));
        users.add(new User(2, "lisi"));
        return users;
    }

    @RequestMapping("/demo4")
    @ResponseBody
    public String demoStream(@RequestBody List<User> users) {
        System.out.println(users);
        return users.toString();
    }
}
