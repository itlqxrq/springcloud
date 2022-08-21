package com.singularity.springcloud.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 18:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Integer id;

    private Integer userId;

    private BigDecimal total;

    private  BigDecimal used;

    private BigDecimal residue;
}
