package com.manzuo.springcloud.service;

import com.manzuo.springcloud.dao.PaymentDao;
import com.manzuo.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 *
 * @author HDU
 * @date 2020/6/24 17:56
 */
@Service
public class PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    public int create(Payment payment){
        return paymentDao.create(payment);
    };

    public Payment getById(Integer id){
        return paymentDao.getById(id);
    };
}
