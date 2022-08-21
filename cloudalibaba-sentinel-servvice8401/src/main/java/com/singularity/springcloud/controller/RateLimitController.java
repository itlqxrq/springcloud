package com.singularity.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.singularity.springcloud.enities.CommonResult;
import com.singularity.springcloud.enities.Payment;
import com.singularity.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 10:36
 */
@RestController
public class RateLimitController {

    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handException")
    public CommonResult byResource(){

        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2022,"serial001"));
    }

    public CommonResult handException(BlockException exception){

        return new CommonResult(444, exception.getClass().getCanonicalName()+"\t 服务不可用");
    }


    @GetMapping(value = "/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){

        return new CommonResult(200,"按url限流测试OK",new  Payment(2022,"serial002"));
    }


    @GetMapping(value = "/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")
    public CommonResult customerBlockHandler(){

        return new CommonResult(200,"按客户自定义",new  Payment(2022,"serial002"));
    }
}
