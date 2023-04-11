package com.shamengxin.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HYSTRIX",fallback = HystrixClientFallBack.class) //fallback：这个属性永安里指定当前带哦用服务不可用时，默认的备选处理
public interface HystrixClient {

    @GetMapping("/demo")
    String demo(@RequestParam("id") Integer id);

}
