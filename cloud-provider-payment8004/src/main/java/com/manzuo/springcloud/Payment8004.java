package com.manzuo.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2020/6/27 18:22
 */
@MapperScan("com.manzuo.springcloud.dao")
@SpringBootApplication
@EnableDiscoveryClient //让注册中心能够发现，扫描到该服务
public class Payment8004 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004.class,args);
    }
}
