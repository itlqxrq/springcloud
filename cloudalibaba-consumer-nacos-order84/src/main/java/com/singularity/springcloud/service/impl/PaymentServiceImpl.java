package com.singularity.springcloud.service.impl;

import com.singularity.springcloud.enities.CommonResult;
import com.singularity.springcloud.enities.Payment;
import com.singularity.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 12:28
 */
@Service
public class PaymentServiceImpl  implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Integer id) {

        return new CommonResult<>(4444,"服务降级返回----PaymentServiceImpl",new Payment(id,"errorSerial"));
    }
}
