package com.singularity.springcloud.service.impl;

import com.singularity.springcloud.dao.OrderDao;
import com.singularity.springcloud.domain.Order;
import com.singularity.springcloud.service.AccountService;
import com.singularity.springcloud.service.OrderService;
import com.singularity.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Singularity
 * @Date: 2022/8/20 16:46
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)//发生任何异常 通通回滚
    public void create(Order order) {

        //新键订单
        log.info("------->开始新建订单");
        orderDao.create(order);

        //扣减库存
        log.info("------->订单微服务开始调用库存模块,开始减去库存");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->订单微服务开始调用库存模块,结束减去库存");

        //扣减账户
        log.info("------->订单微服务开始调用账户模块,开始减去账户余额");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->订单微服务开始调用账户模块,结束减去账户余额");

        //修改订单状态从0到1,1代表完成订单
        log.info("------->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("------->修改订单状态结束");

        log.info("---------->下订单结束了");

    }

}
