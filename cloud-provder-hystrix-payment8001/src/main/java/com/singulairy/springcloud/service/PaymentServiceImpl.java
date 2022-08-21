package com.singulairy.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 18:27
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfoOk(Integer id) {

        return "线程池:"+Thread.currentThread().getName()+"paymentInfoOk,id:"+id;
    }

    @Override
    @SneakyThrows
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeOut(Integer id) {
        //Integer second = 5;
//        Integer age = 10/0;
        TimeUnit.SECONDS.sleep(3);
        return "线程池:"+Thread.currentThread().getName()+"paymentInfoTimeOut,id:"+id;
    }


    public String paymentInfoTimeOutHandler(Integer id){

        return "线程池:"+Thread.currentThread().getName()+"paymentInfoTimeOutHandler,id:"+id+"超时请稍后再试";
    }



    /**
     * 服务熔断 超时、异常、都会触发熔断
     * 1、默认是最近10秒内收到不小于10个请求，<br/>
     * 2、并且有60%是失败的<br/>
     * 3、就开启断路器<br/>
     * 4、开启后所有请求不再转发，降级逻辑自动切换为主逻辑，减小调用方的响应时间<br/>
     * 5、经过一段时间（时间窗口期，默认是5秒），断路器变为半开状态，会让其中一个请求进行转发。<br/>
     * &nbsp;&nbsp;5.1、如果成功，断路器会关闭，<br/>
     * &nbsp;&nbsp;5.2、若失败，继续开启。重复4和5<br/>
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
//          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")// 超时处理
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){

        if (id < 0){
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号:"+serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id){

        return "id不能为负数,请稍后再试   id:"+id;
    }
}
