package com.example.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

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
    }
}

