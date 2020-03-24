package com.example;

import org.junit.Test;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:50 on 2020/3/24
 * @version V0.1
 * @classNmae LambdaTest
 */

public class LambdaTest {

    @Test
    public void lambdavsanonymousclass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        }).start();

        new Thread(() -> System.out.println("hello2")).start();
    }

}
