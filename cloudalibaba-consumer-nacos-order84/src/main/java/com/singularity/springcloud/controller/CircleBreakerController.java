package com.singularity.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.singularity.springcloud.enities.CommonResult;
import com.singularity.springcloud.enities.Payment;
import com.singularity.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 11:38
 */
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL="http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;


    @GetMapping(value = "/consumer/paymentSQL/{id}")
    //@SentinelResource(value = "fallback") //没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel的违规配置
    @SentinelResource(value = "fallback",fallback = "handlerFallback",
            blockHandler = "blockHandler",exceptionsToIgnore =IllegalArgumentException.class )
    public CommonResult<Payment> fallback(@PathVariable("id") Integer id ){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class,id);

        if (id == 4){

            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }else if (result.getData() == null){

            throw new NullPointerException("NullPointerException,空指针异常");
        }

        return result;
    }

    public CommonResult handlerFallback(@PathVariable("id") Integer id,Throwable e){

        Payment payment = new Payment(id, "null");

        return  new CommonResult<>(444,"兜底异常handlerFaller,exception内容"+e.getMessage(),payment);
    }

    public CommonResult blockHandler(@PathVariable("id") Integer id, BlockException exception){

        Payment payment = new Payment(id, null);

        return new CommonResult(445,"blockHandler-sentinel限流,无此流水: blockException"+exception.getClass().getCanonicalName());
    }

    //================================openFeign

    @GetMapping(value = "/consumer/openFeign/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Integer id){

        return paymentService.paymentSQL(id);

    }

}
