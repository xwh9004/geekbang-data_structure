package com.example.concurrent;

import org.junit.Test;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:24 on 2020/3/31
 * @version V0.1
 * @classNmae BalkingTest
 */
public class BalkingTest {

    @Test
    public void balkingTest() throws InterruptedException {
        System.out.println(System.currentTimeMillis()+ ":start");
        BalkingDemo demo = new BalkingDemo();
        for (int i=0;i<1000;i++)
        new Thread(() -> {
            demo.init();
        }).start();

        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis()+ ":"+demo.getCount());

    }
}
