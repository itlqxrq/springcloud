package com.singularity.springcloud.service.impl;

import com.singularity.springcloud.dao.StorageDao;
import com.singularity.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 18:19
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {


    @Resource
    private StorageDao storageDao;

    @Override
    public void update(Integer productId, Integer count) {

        log.info("-------------------->storage-service中扣减库存开始");
        storageDao.update(productId,count);
        log.info("-------------------->storage-service中扣减库存结束");

    }
}
