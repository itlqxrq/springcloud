package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Singularity
 * @Date: 2022/8/18 13:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPaymentMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaPaymentMain9001.class,args);
    }
}
