package com.singularity.springcloud.controller;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 14:20
 */
@RestController
@Slf4j
public class OrderZookeeperController {

    private static final String ZK_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/zookeeper")
    public String paymentInfo(){
        String object = restTemplate.getForObject(ZK_URL + "/payment/zookeeper", String.class);
        return object;
    }

}
