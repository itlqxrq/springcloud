package com.singulairy.springcloud.service;


/**
 * @Author: Singularity
 * @Date: 2022/8/16 18:26
 */
public interface PaymentService {

    String paymentInfoOk(Integer id);

    String paymentInfoTimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
