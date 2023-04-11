package com.shamengxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启openFeign的调用
public class OpenFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignHystrixApplication.class,args);
    }

}
