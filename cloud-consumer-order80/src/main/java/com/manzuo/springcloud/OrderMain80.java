package com.manzuo.springcloud;

import com.manzuo.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by IntelliJ IDEA
 *
 * @author HDU
 * @date 2020/6/24 18:26
 */
@SpringBootApplication
@EnableEurekaClient
//针对CLOUD-PAYMENT-SERVICE服务,采用自定义的轮询规则(MySelfRule类定义了轮询方式为随机)
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
