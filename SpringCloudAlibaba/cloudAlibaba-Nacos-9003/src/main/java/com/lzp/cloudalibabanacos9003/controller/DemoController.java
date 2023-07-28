package com.lzp.cloudalibabanacos9003.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LZPing
 * @date: 2023-05-06 16:22
 * @Description
 */

@RestController
public class DemoController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/lzp")
    public String getServerPort() {
        return "Hello Nacos Discovery" + serverPort;
    }
}