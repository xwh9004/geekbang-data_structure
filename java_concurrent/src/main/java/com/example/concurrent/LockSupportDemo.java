package com.example.concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.locks.LockSupport;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:25 on 2020/4/26
 * @version V0.1
 * @classNmae LockSupportDemo
 */
public class LockSupportDemo {



    @SneakyThrows(InterruptedException.class)
    public static void main(String[] args) {
        Thread t = new Thread(){

            @SneakyThrows(InterruptedException.class)
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    Thread.sleep(200);
                    if(i==5){
//                        System.out.println("park1 Thread t");
//                        LockSupport.park();
                        System.out.println("park Thread t 3000000000");
                        LockSupport.parkNanos(3000000000L);
                        System.out.println("unpark Thread t after 3000000000ns");
                    }
                    System.out.println(i);
                }
            }
        };
        t.start();
        Thread.sleep(5000);

//        LockSupport.unpark(t);
//        System.out.println("unpark Thread t");


    }
}
