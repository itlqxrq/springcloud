package com.singularity.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Singularity
 * @Date: 2022/8/18 14:43
 */
@RestController
@RefreshScope//支持nacos的动态刷新的功能
public class ConfigClientController {


    @Value("${config.info}")
    private String configInfo;


    @GetMapping(value = "/config/info")
    public String getConfigInfo(){

        return configInfo;
    }
}
