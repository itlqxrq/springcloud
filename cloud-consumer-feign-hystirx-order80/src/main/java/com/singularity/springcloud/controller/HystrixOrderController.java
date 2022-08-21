package com.singularity.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.singularity.springcloud.service.PaymentServiceInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 19:15
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class HystrixOrderController {

    @Resource
    private PaymentServiceInfo paymentServiceInfo;


    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {

        return paymentServiceInfo.paymentInfoOk(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    @SneakyThrows
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {

        return paymentServiceInfo.paymentInfoTimeOut(id);
    }

    public String paymentInfoTimeOutHandler(@PathVariable("id") Integer id){

        return "我是消费者80,现在系统繁忙,请稍后再试";
    }

    //全局fallback
    public String payment_Global_FallbackMethod(){

        return "Global异常信息,请稍后再试";
    }
}
