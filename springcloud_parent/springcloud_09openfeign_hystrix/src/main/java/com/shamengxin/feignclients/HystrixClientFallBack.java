package com.shamengxin.feignclients;

import org.springframework.stereotype.Component;

//自定义hystrix默认备选处理方案
@Component
public class HystrixClientFallBack implements HystrixClient{
    @Override
    public String demo(Integer id) {
        return "当前服务不可用，请稍后再试！ id:"+id;
    }
}
