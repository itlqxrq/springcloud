package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Singularity
 * @Date: 2022/8/18 14:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliConsumerOrderMain83 {

    public static void main(String[] args) {
        SpringApplication.run(AliConsumerOrderMain83.class,args);
    }
}
