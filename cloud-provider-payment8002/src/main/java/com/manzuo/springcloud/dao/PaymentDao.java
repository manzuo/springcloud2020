package com.manzuo.springcloud.dao;

import com.manzuo.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA
 *
 * @author HDU
 * @date 2020/6/24 17:51
 */
@Mapper
@Repository
public interface PaymentDao {
    @Insert("insert into payment(serial) values(#{serial})")
    public int create(Payment payment);
    @Select("select * from payment where id = #{id}")
    public Payment getById(Integer id);

}
