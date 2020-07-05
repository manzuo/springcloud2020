package com.manzuo.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2020/7/5 17:06
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
