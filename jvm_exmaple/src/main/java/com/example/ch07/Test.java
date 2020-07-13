package com.example.ch07;

import java.lang.reflect.Method;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:54 on 2020/1/15
 * @version V0.1
 * @classNmae Test
 */
public class Test {
    public static void target(int i) {

    }

    public static void main(String[] args) throws Exception {
        Class klass = Class.forName("com.example.ch07.Test");
        Method method = klass.getMethod("target", int.class);
        polluteProfile();
        method.setAccessible(true); // 关闭权限检查
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            method.invoke(null, 128);
        }
    }

    public static void polluteProfile() throws Exception {
        Method method1 = Test.class.getMethod("target", int.class);
        Method method2 = Test.class.getMethod("target", int.class);
        //返回的是方法的拷贝
        System.out.println(method1==method2);
        for (int i = 0; i < 2; i++) {
            method1.invoke(null, 0);
            method2.invoke(null, 0);
        }
    }

    public static void target1(int i) {
    }

    public static void target2(int i) {
    }


}
