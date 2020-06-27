package com.manzuo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA
 *
 * @author HDU
 * @date 2020/6/24 18:30
 */
@Configuration
public class  ApplicationContextConfig {
    @Bean
    @LoadBalanced //开启RestTemplate的负载均衡功能
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
