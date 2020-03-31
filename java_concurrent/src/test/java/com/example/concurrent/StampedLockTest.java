package com.example.concurrent;

import org.junit.Test;

import java.io.IOException;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:46 on 2020/3/27
 * @version V0.1
 * @classNmae StampedLockTest
 */
public class StampedLockTest {
    @Test
    public void stampLock_test() throws InterruptedException, IOException {
        StampedLockDemo lockDemo = new StampedLockDemo();

        for (int i = 0; i < 20; i++) {
            final int t =i;
            new Thread(() -> {
                try {
                    int count = lockDemo.readByStampedLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            final int t =i;
            new Thread(() -> {
                try {
                    lockDemo.writeByStampLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(6000);
//        System.in.read();
//        lockDemo.readCountByReadLock();

    }


}
