package com.singularity.springcloud.service;


import com.singularity.springcloud.enities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Singularity
 * @Date: 2022/8/15 20:16
 */
public interface PaymentService {

    Payment paymentById(@Param("id") Integer id);

    Integer createPayment(Payment payment);
}
