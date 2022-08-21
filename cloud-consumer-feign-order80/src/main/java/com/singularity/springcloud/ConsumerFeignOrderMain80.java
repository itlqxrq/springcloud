package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 17:01
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignOrderMain80.class,args);
    }
}
