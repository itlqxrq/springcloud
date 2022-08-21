package com.singularity.springcloud.service.impl;

import com.singularity.springcloud.dao.PaymentDao;
import com.singularity.springcloud.enities.Payment;
import com.singularity.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Singularity
 * @Date: 2022/8/15 20:17
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public Payment paymentById(Integer id) {
        return paymentDao.paymentById(id);
    }

    @Override
    public Integer createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }
}
