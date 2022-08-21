package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 14:53
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentMain8006.class,args);
    }
}
