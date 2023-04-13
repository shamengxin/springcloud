package com.shamengxin.controller;

import com.shamengxin.feignClients.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/invoke")
    public String invokeProduct(){
        log.info("调用用户服务.....");
        //调用商品服务  缺点1：无法实现负载均衡  缺点2：路径写死问题
        // String result = new RestTemplate().getForObject("http://localhost:9090/product?id=21", String.class);

        //1.discoveryClient使用rabbon组件实现负载均衡 1.引入rabbon依赖（nacos client 存在这个依赖） 2.使用ribbon完成负载均衡
        // List<ServiceInstance> serviceInstances = discoveryClient.getInstances("PRODUCTS");
        // for (ServiceInstance serviceInstance : serviceInstances) {
        //     log.info("服务主机：{} 服务端口：{} 服务uri：{}",serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
        // }
        //2.loadBalanceClient
        // ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCTS");
        // String result = new RestTemplate().getForObject(serviceInstance.getUri() + "/product?id=21", String.class);

        //3.@LoaadBalance注解
        // String result = restTemplate.getForObject("http://PRODUCTS/product?id=21", String.class);

        String result = productClient.product(21);

        log.info("商品服务调用结果：{}",result);
        return result;
    }

}
