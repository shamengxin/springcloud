package com.shamengxin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope //允许远端配置修改自动刷新
public class DemoController {

    @Value("${customer.username}")
    private String username;

    @GetMapping("/demo")
    public String demo(){
        log.info("demo ok");
        return "demo ok !!! username:"+username;
    }

}
