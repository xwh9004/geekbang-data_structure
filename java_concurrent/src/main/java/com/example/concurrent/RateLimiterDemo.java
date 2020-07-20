package com.example.concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:11 on 2020/4/9
 * @version V0.1
 * @classNmae RateLimiterDemo
 */
public class RateLimiterDemo {

    private static long prev;

    public static void main(String[] args) {

        //限流器流速：2个请求/秒
        RateLimiter limiter = RateLimiter.create(2.0);
        //执行任务的线程池
        ExecutorService es = Executors.newFixedThreadPool(1);
        //记录上一次执行时间
        prev = System.nanoTime();
        //测试执行20次
        for (int i = 0; i < 20; i++) {
            //限流器限流
            double d = limiter.acquire();
            System.out.println("double = "+d);
            //提交任务异步执行
            es.execute(() -> {
                long cur = System.nanoTime();
                //打印时间间隔：毫秒
                System.out.println(
                        (cur - prev) / 1000_000);
                prev = cur;
            });
        }

    }
}
