package com.singularity.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 19:09
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerHystrixOrderMain80 {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerHystrixOrderMain80.class,args);
    }
}
