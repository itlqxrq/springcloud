package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Singularity
 * @Date: 2022/8/18 10:23
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitMqProviderMain8801 {

    public static void main(String[] args) {

        SpringApplication.run(RabbitMqProviderMain8801.class,args);
    }
}
