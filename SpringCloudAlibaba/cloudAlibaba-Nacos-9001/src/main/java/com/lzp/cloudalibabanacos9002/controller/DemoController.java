package com.lzp.cloudalibabanacos9002.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LZPing
 * @date: 2023-05-05 22:18
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