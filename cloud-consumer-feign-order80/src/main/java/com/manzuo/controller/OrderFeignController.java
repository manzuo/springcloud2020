package com.manzuo.controller;

import com.manzuo.service.PaymentService;
import com.manzuo.springcloud.entity.CommonResult;
import com.manzuo.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2020/7/5 21:23
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderFeignController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/create")
    public CommonResult<Payment> create(Payment payment){
        log.info(payment.toString());
        return paymentService.create(payment);

    }
    @GetMapping("/get/{id}")
    public CommonResult<Payment> create(@PathVariable(value = "id") Integer id){
        return paymentService.get(id);
    }
}
