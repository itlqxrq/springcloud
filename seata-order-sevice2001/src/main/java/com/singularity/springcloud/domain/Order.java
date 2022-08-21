package com.singularity.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 16:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private Integer id;

    private Integer userId;

    private Integer productId;

    private Integer count;

    private BigDecimal money;

    private Integer status; //订单状态: 0:创建中;1:已完成

}
