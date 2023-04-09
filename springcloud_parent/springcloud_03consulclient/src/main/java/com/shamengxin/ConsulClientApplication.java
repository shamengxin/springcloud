package com.shamengxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication  //代表这是一个Springboot入口应用
@EnableDiscoveryClient   //作用：通用服务注册客户端注解 代表 consul client  zk client  nacos client
public class ConsulClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class,args);
    }
}
