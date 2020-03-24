package com.example.ch07;

import java.lang.reflect.Method;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:11 on 2020/1/15
 * @version V0.1
 * @classNmae Test1
 */
public class Test1 {

    public static void target(int i) {

    }

    public static void main(String[] args) throws Exception {

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            target(128);
        }
    }

}
