package com.singularity.springcloud.controller;


import com.singularity.springcloud.enities.CommonResult;
import com.singularity.springcloud.enities.Payment;
import com.singularity.springcloud.loadbalancer.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author: Singularity
 * @Date: 2022/8/15 21:07
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    //单机版
    //public static final String PAYMENT_URL="http://localhost:8001";

    //集群版
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> createPayment(Payment payment){

        return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentByI2(@PathVariable("id") Integer id){

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {

            return entity.getBody();
        }else {

            return new CommonResult(444,"信息错误",null);
        }

    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size() < 0){

            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instance(instances);

        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }

    @GetMapping(value = "/consumer/payment/zipkin")
    public String paymentZipkin(){

       return restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin",String.class);
    }

    // ====================> zipkin+sleuth
//    @GetMapping(value = "/consumer/payment/zipkin")
//    public String paymentZipkin() {
//        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
//        return result;
//    }



}
