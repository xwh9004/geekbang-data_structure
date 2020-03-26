package com.example.concurrent;

import java.util.concurrent.Semaphore;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:30 on 2020/3/26
 * @version V0.1
 * @classNmae SemaphoreDemo
 */
public class SemaphoreDemo {

    public static int count = 0;

    public static Semaphore semaphore = new Semaphore(1);

    public static void addOne(){
        try {
            semaphore.acquire();
            count+=1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(()->{
            for(int i = 0;i<1000000;i++){
                addOne();
            }
        });
        Thread t2 =new Thread(()->{
            for(int i = 0;i<1000000;i++){
                addOne();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count="+count);
    }
}
