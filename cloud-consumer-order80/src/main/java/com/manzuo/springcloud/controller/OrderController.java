package com.manzuo.springcloud.controller;

import com.manzuo.springcloud.entity.CommonResult;
import com.manzuo.springcloud.entity.Payment;
import com.manzuo.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author HDU
 * @date 2020/6/24 18:29
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {
   // private static final  String URL = "http://localhost:8001";
    private static final  String URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/create")
    public CommonResult<Payment> create(Payment payment){
        log.info(payment.toString());
        return restTemplate.postForObject(URL+"/payment/create",payment,CommonResult.class);

    }
    @GetMapping("/get/{id}")
    public CommonResult<Payment> create(@PathVariable Integer id){
        return restTemplate.getForObject(URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances==null||instances.size()<=0){
            return "Service Not Found";
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        //为了使用自己的轮询算法, restTemplate Bean的@LoadBalanced 注解删除
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
