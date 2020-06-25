package com.manzuo.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA
 *
 * @author HDU
 * @date 2020/6/24 17:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private long id;
    private String serial;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }
}
