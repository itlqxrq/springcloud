package com.singularity.springcloud.controller;

import com.singularity.springcloud.domain.CommonResult;
import com.singularity.springcloud.domain.Order;
import com.singularity.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 17:09
 */
@RestController
public class OrderController {


    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order){

        orderService.create(order);

        return new CommonResult(200,"订单创建完成");
    }
}
