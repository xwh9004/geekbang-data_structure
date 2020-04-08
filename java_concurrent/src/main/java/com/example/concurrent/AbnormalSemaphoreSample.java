package com.example.concurrent;

import java.util.concurrent.Semaphore;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:32 on 2020/4/1
 * @version V0.1
 * @classNmae AbnormalSemaphoreSample
 */
public class AbnormalSemaphoreSample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyWorker(semaphore));
            t.start();
        }
        System.out.println("Action...GO!");
        semaphore.release(1);
        System.out.println("Wait for permits off");
        while (semaphore.availablePermits()!=0) {
            Thread.sleep(100L);
        }
        System.out.println("Action...GO again!");
        semaphore.release(9);
    }
}
class MyWorker implements Runnable {
    private Semaphore semaphore;
    public MyWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" Executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

