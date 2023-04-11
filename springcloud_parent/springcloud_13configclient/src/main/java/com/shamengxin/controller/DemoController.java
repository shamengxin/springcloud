package com.shamengxin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope //作用：RefreshScope 用来在不需要重启微服务情况下，将当前scope域中信息刷新为最新配置信息
public class DemoController {

    @Value("${name}")
    private String name;

    @GetMapping("/demo")
    public String demo(){
        log.info("demo ok");
        return "demo ok"+name;
    }

}
