package com.example;

import com.example.common.mistakes.entity.Order;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:59 on 2020/3/25
 * @version V0.1
 * @classNmae FilterTest
 */
public class FilterTest {
    @Test
    public void filterTest() {

//最近半年的金额大于40的订单
        List<Order> orders = Order.getData();
        System.out.println("*******orders 全量**********size=" + orders.size());
        orders.stream().forEach(System.out::println);


        orders = orders.stream().filter(Objects::nonNull).collect(Collectors.toList()); //过滤null值
        System.out.println("*******orders 过滤null值**********size=" + orders.size());
        orders.stream().forEach(System.out::println);

        orders = orders.stream()
                .filter(order -> order.getPlacedAt().isAfter(LocalDateTime.now().minusMonths(6)))
                .collect(Collectors.toList()); //最近半年的订单
        System.out.println("*******orders 最近半年的订单**********size=" + orders.size());
        orders.stream().forEach(System.out::println);

        orders.stream()
                .filter(order -> order.getTotalPrice() > 40)
                .collect(Collectors.toList()); //金额大于40的订单

        System.out.println("*******orders 金额大于40的订单**********size=" + orders.size());
        orders.stream().forEach(System.out::println);
    }

    @Test
    public void filter_test() {
        List<Order> orders = Order.getData();


//最近半年的金额大于40的订单
        orders.stream()
                .filter(Objects::nonNull) //过滤null值
                .filter(order -> order.getPlacedAt().isAfter(LocalDateTime.now().minusMonths(6))) //最近半年的订单
                .filter(order -> order.getTotalPrice() > 40).sorted(Comparator.comparing(Order::getTotalPrice).reversed()) //金额大于40的订单
                .forEach(System.out::println);
    }

    @Test
    public void map_test() {
     //所有下单的用户，使用toSet去重后实现字符串拼接
        List<Order> orders = Order.getData();
        System.out.println(orders.stream()
                .map(order -> order.getCustomerName()).collect(toSet())
                .stream().collect(joining(",", "[", "]")));


    }
}


