package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 14:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperOrderMain80 {

    public static void main(String[] args) {

        SpringApplication.run(ZookeeperOrderMain80.class,args);
    }
}
