package com.singularity.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 15:08
 */

@RestController
@Slf4j
public class ConsulOrderController {

    private static final String CONSUL_URL="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String object = restTemplate.getForObject(CONSUL_URL + "/payment/consul", String.class);
        return object;
    }

}
