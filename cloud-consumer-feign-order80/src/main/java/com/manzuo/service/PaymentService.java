package com.manzuo.service;

import com.manzuo.springcloud.entity.CommonResult;
import com.manzuo.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2020/7/5 21:14
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentService {
    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable(value = "id") Integer id);
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment);
}
