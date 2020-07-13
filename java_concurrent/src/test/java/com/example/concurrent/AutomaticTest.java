package com.example.concurrent;

import org.junit.Test;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:13 on 2020/3/30
 * @version V0.1
 * @classNmae AutomaticTest
 */
public class AutomaticTest {

    @Test
   public void add100k() throws InterruptedException {

        Counter counter = new Counter();
        Thread t1 = new Thread(()->counter.add10m_unsafe());
        Thread t2 = new Thread(()->counter.add10m_unsafe());
        Thread t3 = new Thread(()->counter.add10m_safe());
        Thread t4 = new Thread(()->counter.add10m_safe());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println(counter.count);
        System.out.println(counter.count_safe);
   }
}
