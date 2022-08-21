package com.singularity.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 20:17
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentServiceInfo {
    @Override
    public String paymentInfoOk(Integer id) {

        return "-----PaymentFallbackService fall back-paymentInfoOk";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfoTimeOut";
    }
}
