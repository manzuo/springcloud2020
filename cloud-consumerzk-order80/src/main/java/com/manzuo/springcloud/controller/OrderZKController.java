package com.manzuo.springcloud.controller;

import com.manzuo.springcloud.entity.CommonResult;
import com.manzuo.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA
 *
 * @author HDU
 * @date 2020/6/24 18:29
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderZKController {
   // private static final  String URL = "http://localhost:8001";
    private static final  String URL = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/payment/zk")
    public String zk(){
        return restTemplate.getForObject(URL+"/payment/zk",String.class);

    }
}
