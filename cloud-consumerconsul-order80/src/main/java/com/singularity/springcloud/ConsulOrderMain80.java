package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 15:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderMain80.class,args);
    }
}
