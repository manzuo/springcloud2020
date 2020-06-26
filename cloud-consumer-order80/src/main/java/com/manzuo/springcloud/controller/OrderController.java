package com.manzuo.springcloud.controller;

import com.manzuo.springcloud.entity.CommonResult;
import com.manzuo.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
public class OrderController {
   // private static final  String URL = "http://localhost:8001";
    private static final  String URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info(payment.toString());
        return restTemplate.postForObject(URL+"/payment/create",payment,CommonResult.class);

    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable Integer id){
        return restTemplate.getForObject(URL+"/payment/get/"+id,CommonResult.class);
    }
}
