package com.singularity.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 18:17
 */
@Mapper
public interface StorageDao {

    void update(@Param("productId") Integer productId,@Param("count") Integer count);
}
