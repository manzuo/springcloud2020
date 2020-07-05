package com.manzuo.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2020/7/5 17:09
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger nextInteger = new AtomicInteger(0);
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.nextInteger.get();
             next =current>=Integer.MAX_VALUE?0:current+1;
        }while (!this.nextInteger.compareAndSet(current,next));
        System.out.println("*********第几次访问,次数 next:"+next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
