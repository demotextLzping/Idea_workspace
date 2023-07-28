package com.lzp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: LZPing
 * @date: 2022-11-28 16:30
 * @Description
 */
@Controller
public class successController {
    @RequestMapping("success")
    @ResponseBody
    public String suc() {
        return "success";
    }
}
