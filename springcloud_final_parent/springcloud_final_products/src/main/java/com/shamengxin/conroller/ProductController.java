package com.shamengxin.conroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/product")
    public String product() {
        log.info("product ok.....");

        return "product ok,当前服务的端口号为" + port;
    }

}
