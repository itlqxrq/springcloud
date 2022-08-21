package com.singularity.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 18:51
 */
public interface AccountService {

    void update( Integer userId,  BigDecimal money);
}
