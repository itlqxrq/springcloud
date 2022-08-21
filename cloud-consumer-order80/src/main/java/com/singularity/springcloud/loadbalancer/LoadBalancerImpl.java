package com.singularity.springcloud.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Singularity
 * @Date: 2022/8/16 16:22
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public  final  Integer getAndIncrement(){

        Integer current;

        Integer next;

        do {
            current = this.atomicInteger.get();

            next = current > Integer.MAX_VALUE ? 0: current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));

        System.out.println("访问次数next:" + next);

        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        Integer integer = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(integer);
    }
}
