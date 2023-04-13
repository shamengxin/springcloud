package com.shamengxin.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @GetMapping("/demo")//blockHandler 使用sentinel进行不同规则控制时的默认处理方案   fallback：自定义业务出错时默认处理方案   defaultFallback 指定一个业务出错时的默认处理方案
    @SentinelResource(value = "demo",blockHandler = "blockHandler",fallback = "fallCustomer",defaultFallback = "fall")//这是一个sentinel资源
    public String demo(Integer id){
        log.info("demo Ok...");
        if(id<0) throw new RuntimeException("id无效");
        return "demo ok!!!";
    }

    public String blockHandler(Integer id, BlockException e){
        if(e instanceof FlowException){
            return "当前亲贵过于火爆，您已被流量控制！！！";
        }
        if (e instanceof DegradeException){
            return "当前亲贵过于火爆，您已被降级！！！";
        }
        if (e instanceof ParamFlowException){
            return "当前亲贵过于火爆，您已被热点参数限流！！！";
        }
        return "服务器已满，请稍后再试";
    }

    public String fallCustomer(Integer id){
        return "自定义的服务系统出错！！！";
    }

    public String fall(){
        return "服务器出错了！！！";
    }

    @GetMapping("/test")
    public String test(){
        log.info("test Ok...");
        return "test ok!!!";
    }

}
