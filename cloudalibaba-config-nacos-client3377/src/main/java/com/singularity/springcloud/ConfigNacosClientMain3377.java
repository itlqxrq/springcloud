package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Singularity
 * @Date: 2022/8/18 14:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigNacosClientMain3377 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigNacosClientMain3377.class,args);
    }
}
