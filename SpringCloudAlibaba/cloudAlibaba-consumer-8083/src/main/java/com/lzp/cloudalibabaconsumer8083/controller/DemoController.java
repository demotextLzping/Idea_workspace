package com.lzp.cloudalibabaconsumer8083.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: LZPing
 * @date: 2023-05-05 22:34
 * @Description
 */

@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("consumer/nacos")
    public String getDiscovery() {
        return restTemplate.getForObject(serverUrl+"/lzp",String.class);
    }
}