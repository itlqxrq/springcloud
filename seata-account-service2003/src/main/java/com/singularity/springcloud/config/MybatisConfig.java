package com.singularity.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 17:13
 */
@Configuration
@MapperScan({"com.singularity.springcloud.dao"})
public class MybatisConfig {
}
