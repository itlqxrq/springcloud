package com.singularity.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.singularity.springcloud.enities.CommonResult;
import com.singularity.springcloud.enities.Payment;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 10:55
 */
public class CustomerBlockHandler {

    public static CommonResult handleException1(BlockException exception){

        return new CommonResult(444,"按客户自定义的,global handlerException-----1");

    }



    public static CommonResult handleException2(BlockException exception){

        return new CommonResult(444,"按客户自定义的,global handlerException-----2");

    }
}
