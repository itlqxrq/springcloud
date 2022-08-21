package com.singularity.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Singularity
 * @Date: 2022/8/19 14:52
 */
@RestController
@Slf4j
public class FlowLimitController {

    @SneakyThrows
    @GetMapping(value = "/testA")
    public String testA(){
//        TimeUnit.MILLISECONDS.sleep(800);
        return "---------------testA";
    }

    @GetMapping(value = "/testB")
    public String testB(){

        return "---------------testB";
    }


    @SneakyThrows
    @GetMapping(value = "/testD")
    public String testD(){
        TimeUnit.SECONDS.sleep(1);
        log.info(Thread.currentThread().getName()+"\t"+".......testD");
        return "---------------testD";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
        @RequestParam(value = "p2",required = false)String p2){
        Integer age = 10 /0;
        return "---------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){

        return "---------deal_testHotKey";
    }

}
