package com.singularity.springcloud.service;

import com.singularity.springcloud.enities.CommonResult;
import lombok.SneakyThrows;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 17:06
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/getPaymentById/{id}")
    CommonResult getPaymentById(@PathVariable("id") Integer id);


    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
