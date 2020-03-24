package com.pattern.callback;

/**
 * <p><b>Description:</b>
 * JVM 在shutdown 之前执行的 线程
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:05 on 2020/3/24
 * @version V0.1
 * @classNmae ShutdownHookDemo
 */
public class ShutdownHookDemo {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            {
                System.out.println("I am called during shutting down");}
        }) );
    }
}
