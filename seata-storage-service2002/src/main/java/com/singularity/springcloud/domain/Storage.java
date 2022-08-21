package com.singularity.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 18:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Integer id;

    private Integer productId;

    private Integer total;

    private Integer used;

    private Integer residue;
}
