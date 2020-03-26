package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:37 on 2020/3/25
 * @version V0.1
 * @classNmae Customer
 */
//顾客类
@Data
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;//顾客姓名


    public static List<Customer> getData() {
        return Arrays.asList(
                new Customer(10L, "小张"),
                new Customer(11L, "小王"),
                new Customer(12L, "小李"),
                new Customer(13L, "小朱"),
                new Customer(14L, "小徐")
        );
    }
}