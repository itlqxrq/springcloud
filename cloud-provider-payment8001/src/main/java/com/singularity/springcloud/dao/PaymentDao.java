package com.singularity.springcloud.dao;

import com.singularity.springcloud.enities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Singularity
 * @Date: 2022/8/15 20:01
 */
@Mapper
public interface PaymentDao {

    Payment paymentById(@Param("id") Integer id);

    Integer createPayment(Payment payment);
}
