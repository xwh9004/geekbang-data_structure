package com.example.concurrent;

import java.util.concurrent.*;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:04 on 2020/3/27
 * @version V0.1
 * @classNmae ThreadPoolExecutorDemo
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建FutureTask
        FutureTask futureTask = new FutureTask<Integer>(()-> 1+2);
        // 创建线程池
        ExecutorService es = Executors.newCachedThreadPool();
        //提交FutureTask
        es.submit(futureTask);
        // 获取计算结
        Integer result = (Integer) futureTask.get();
        System.out.println(result);

         es =  Executors.newSingleThreadExecutor();


        es.execute(()->{
            System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getId());
            System.out.println("a job");
            //如何抛异常，这会重新创建新线程
            throw new RuntimeException("test exception");

        });
        TimeUnit.SECONDS.sleep(2);
        es.execute(()->{
            System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getId());
            System.out.println("other job...");
        });
    }
}

