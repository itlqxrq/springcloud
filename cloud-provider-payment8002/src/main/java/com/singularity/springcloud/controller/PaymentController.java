package com.singularity.springcloud.controller;

import com.singularity.springcloud.enities.CommonResult;
import com.singularity.springcloud.enities.Payment;
import com.singularity.springcloud.service.PaymentService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Singularity
 * @Date: 2022/8/15 20:20
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;



    @PostMapping(value = "/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment){

        Integer integer = paymentService.createPayment(payment);

        log.info("插入结果:"+integer);

        if (integer > 0 ){

            return  new CommonResult(200,"插入成功,serverPort:"+serverPort,integer);
        }else {

            return  new CommonResult(444,"插入失败",null);
        }
    }


    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){

        Payment payment = paymentService.paymentById(id);

        log.info("查询结果:"+payment);

        if (payment != null ){

            return  new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else {

            return  new CommonResult(444,"没有对应的记录,查询id:"+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){

        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    @SneakyThrows
    public String paymentFeignTimeout(){
        //线程停3秒钟 秒钟模拟超时
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }


}
