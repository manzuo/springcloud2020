package com.manzuo.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2020/7/5 1:48
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
//      轮询方式定义为随机
        return new RandomRule();
    }
}
