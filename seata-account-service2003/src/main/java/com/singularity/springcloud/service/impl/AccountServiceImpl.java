package com.singularity.springcloud.service.impl;

import com.singularity.springcloud.dao.AccountDao;
import com.singularity.springcloud.service.AccountService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 18:52
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    @SneakyThrows
    public void update(Integer userId, BigDecimal money) {
        log.info("--------------->金额扣减之前");
        //模拟超时异常,全局事务回滚
//        TimeUnit.SECONDS.sleep(20);
        accountDao.update(userId,money);
        log.info("--------------->金额扣减之后");
    }
}
