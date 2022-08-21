package com.singularity.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 15:53
 */
@Configuration
public class MySelfRule {


    @Bean
    public IRule myRule(){

        return new RandomRule();//默认为随机
    }
}
