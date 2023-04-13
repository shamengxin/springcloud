package com.shamengxin.controller;

import com.shamengxin.controller.feignclients.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/invoke")
    public String invokeProduct(){
        log.info("user invoke ok....");
        // String result = restTemplate.getForObject("http://PRODUCTS/product", String.class);

        String result = productClient.product();

        log.info("result:{}",result);
        return result;
    }

}
