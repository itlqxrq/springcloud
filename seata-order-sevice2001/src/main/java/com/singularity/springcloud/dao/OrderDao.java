package com.singularity.springcloud.dao;

import com.singularity.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 16:22
 */
@Mapper
public interface OrderDao {

    //新建订单
    void create(Order order);

    //修改订单的状态
    void update(@Param("userId") Integer userId,@Param("status") Integer status);
}
