package com.shamengxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// @EnableDiscoveryClient  //注意：默认只要引入discovery client依赖，该注解无需显示声明 自动注册
@EnableHystrixDashboard   //注意：这个注解用来开启当前应用为仪表盘应用
public class HystrixDashBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplication.class,args);
    }

}
