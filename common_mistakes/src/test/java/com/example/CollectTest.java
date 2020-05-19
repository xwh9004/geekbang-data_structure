package com.example;

import com.example.common.mistakes.entity.Order;
import com.example.common.mistakes.entity.OrderItem;
import org.junit.Before;
import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 11:14 on 2020/3/25
 * @version V0.1
 * @classNmae CollectTest
 */
public class CollectTest {


    List<Order> orders;

    @Before
    public void init() {
        orders = Order.getData();
    }

    @Test
    public void string_test() {
        Random random = new Random();
        //生成一定位数的随机字符串
        System.out.println(random.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(20)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString());
    }
    @Test
    public void collect_test() {

//按照用户名分组，统计下单数量
        System.out.println(orders.stream().collect(groupingBy(Order::getCustomerName, counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(toList()));

//按照用户名分组，统计订单总金额
        System.out.println(orders.stream().collect(groupingBy(Order::getCustomerName, summingDouble(Order::getTotalPrice)))
                .entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(toList()));

//按照用户名分组，统计商品采购数量
        System.out.println(orders.stream().collect(groupingBy(Order::getCustomerName,
                summingInt(order -> order.getOrderItemList().stream()
                        .collect(summingInt(OrderItem::getProductQuantity)))))
                .entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(toList()));

//统计最受欢迎的商品，倒序后取第一个
        orders.stream()
                .flatMap(order -> order.getOrderItemList().stream())
                .collect(groupingBy(OrderItem::getProductName, summingInt(OrderItem::getProductQuantity)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println);

//统计最受欢迎的商品的另一种方式，直接利用maxBy
        orders.stream()
                .flatMap(order -> order.getOrderItemList().stream())
                .collect(groupingBy(OrderItem::getProductName, summingInt(OrderItem::getProductQuantity)))
                .entrySet().stream()
                .collect(maxBy(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);

//按照用户名分组，选用户下的总金额最大的订单
        orders.stream().collect(groupingBy(Order::getCustomerName, collectingAndThen(maxBy(comparingDouble(Order::getTotalPrice)), Optional::get)))
                .forEach((k, v) -> System.out.println(k + "#" + v.getTotalPrice() + "@" + v.getPlacedAt()));

//根据下单年月分组，统计订单ID列表
        System.out.println(orders.stream().collect
                (groupingBy(order -> order.getPlacedAt().format(DateTimeFormatter.ofPattern("yyyyMM")),
                        mapping(order -> order.getId(), toList()))));

//根据下单年月+用户名两次分组，统计订单ID列表
        System.out.println(orders.stream().collect
                (groupingBy(order -> order.getPlacedAt().format(DateTimeFormatter.ofPattern("yyyyMM")),
                        groupingBy(order -> order.getCustomerName(),
                                mapping(order -> order.getId(), toList())))));
    }
}
