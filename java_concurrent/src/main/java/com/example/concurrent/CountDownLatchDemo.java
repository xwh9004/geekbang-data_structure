package com.example.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:09 on 2020/3/27
 * @version V0.1
 * @classNmae CountDownLatchDemo
 */
public class CountDownLatchDemo {

    // 创建2个线程的线程池

    Executor executor = Executors.newFixedThreadPool(2);


    CountDownLatch latch = new CountDownLatch(2);

    CyclicBarrier barrier = new CyclicBarrier(2);
}
