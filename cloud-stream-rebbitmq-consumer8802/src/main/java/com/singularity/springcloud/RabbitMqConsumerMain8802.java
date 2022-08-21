package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Singularity
 * @Date: 2022/8/18 11:04
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitMqConsumerMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqConsumerMain8802.class,args);
    }
}
