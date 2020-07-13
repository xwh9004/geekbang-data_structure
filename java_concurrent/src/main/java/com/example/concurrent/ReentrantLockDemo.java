package com.example.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:41 on 2020/4/17
 * @version V0.1
 * @classNmae ReentrantLockDemo
 */
public class ReentrantLockDemo {

    public static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
               for (int i=0;i<10;i++){
                   if(i==6){
                       Thread.currentThread().interrupt();
                   }
                   //清空中断标识位
                   if( Thread.interrupted()){
                       System.out.println("isInterrupted i="+i);
                   }
                   System.out.println("i="+i);
               }
        });
        t.start();
        t.join();

    }
}
