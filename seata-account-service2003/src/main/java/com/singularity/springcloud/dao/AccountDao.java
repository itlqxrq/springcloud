package com.singularity.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 18:49
 */
@Mapper
public interface AccountDao {

    void update(@Param("userId") Integer userId, @Param("money")BigDecimal money);
}
