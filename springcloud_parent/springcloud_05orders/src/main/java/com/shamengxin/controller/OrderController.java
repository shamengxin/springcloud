package com.shamengxin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private int port;

    @GetMapping("order")
    public String demo(){
        log.info("order demo...");
        return "order demo OK!!!,当前提供服务的端口为："+port;
    }

}
