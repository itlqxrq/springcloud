package com.singularity.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 16:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private  T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
