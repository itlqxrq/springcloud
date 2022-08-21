package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Singularity
 * @Date: 2022/8/18 14:02
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaPaymentMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaPaymentMain9002.class,args);
    }
}
