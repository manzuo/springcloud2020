package com.manzuo.springcloud.controller;

import com.manzuo.springcloud.entity.CommonResult;
import com.manzuo.springcloud.entity.Payment;
import com.manzuo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA
 *
 * @author HDU
 * @date 2020/6/24 17:58
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
//    @PostMapping("/create")
//    public CommonResult create(@RequestBody Payment payment){
//        int i = paymentService.create(payment);
//        log.info("插入的结果为:"+i);
//        if(i<0)
//            return new CommonResult(500,"插入失败,port="+port);
//        else
//            return new CommonResult(200,"插入成功,port="+port);
//    }
//    @GetMapping("get/{id}")
//    public CommonResult<Payment> get(@PathVariable Integer id){
//        Payment payment = paymentService.getById(id);
//        if (payment!=null){
//            return new CommonResult<Payment>(200,"查询成功,port="+port,payment);
//        }
//        else {
//            return new CommonResult<Payment>(200,"查询失败,port="+port);
//        }
//    }
    @GetMapping(value = "/zk")
    public String paymentzk(){
        return "Spring Cloud with zookeeper "+ port+ "\n"+ UUID.randomUUID().toString();
    }
}
