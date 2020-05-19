package com.example.common.mistakes.entity;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p><b>Description:</b>
 * 子类重写父类方法失败的案例
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:24 on 2020/4/24
 * @version V0.1
 * @classNmae Parent
 */

public class Parent<T> {
    //用于记录value更新的次数，模拟日志记录的逻辑
    AtomicInteger updateCount = new AtomicInteger();
    private T value;
    //重写toString，输出值和值更新次数
    @Override
    public String toString() {
        return String.format("value: %s updateCount: %d", value, updateCount.get());
    }
    //设置值
    public void setValue(T value) {
        System.out.println("Parent.setValue called");
        this.value = value;
        updateCount.incrementAndGet();

    }

    public static void main(String[] args) {

        Child1 child1 = new Child1();
        Arrays.stream(child1.getClass().getDeclaredMethods())
                .filter(method -> method.getName().equals("setValue")&&method.getParameterTypes()[0].equals(Object.class))
                .forEach(method -> {
                    try {
                        method.invoke(child1, "test");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        System.out.println(child1.toString());
    }
}

class Child1 extends Parent<String> {

    @Override
    public void setValue(String value) {

        System.out.println("Child1.setValue called");
        super.setValue(value);
    }
}
