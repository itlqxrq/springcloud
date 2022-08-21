package com.singularity.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.singularity.springcloud.enities.CommonResult;
import com.singularity.springcloud.enities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 11:18
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Integer, Payment> hashMap = new HashMap<>();

    static {

        hashMap.put(1,new Payment(1, IdUtil.simpleUUID()));
        hashMap.put(2,new Payment(2, IdUtil.simpleUUID()));
        hashMap.put(3,new Payment(3, IdUtil.simpleUUID()));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id){

        Payment payment = hashMap.get(id);

        return new CommonResult<Payment>(200,"form mysql,serverPort:"+serverPort,payment);
    }
}
