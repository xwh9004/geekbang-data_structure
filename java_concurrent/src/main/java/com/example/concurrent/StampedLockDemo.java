package com.example.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:57 on 2020/3/27
 * @version V0.1
 * @classNmae StampedLockDemo
 */
public class StampedLockDemo {
    private static int count = 0;
    private final StampedLock sl = new StampedLock();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    public int readByStampedLock() throws InterruptedException {
        //获取/释放悲观读锁示意代码
        long stamp = sl.readLock();
        try {
            System.out.println("count__="+Thread.currentThread().getName()+"_"+count);
            //省略业务相关代码
            Thread.sleep(2000);
            System.out.println("count__="+Thread.currentThread().getName()+"_"+count);
            return count;
        } finally {
            sl.unlockRead(stamp);
        }
    }


    public int readByReadLock() throws InterruptedException {
        //获取/释放悲观读锁示意代码
        try {
            readLock.lock();
            System.out.println("count__="+Thread.currentThread().getName()+"_"+count);
            Thread.sleep(1000);
            System.out.println("count__="+Thread.currentThread().getName()+"_"+count);
            //省略业务相关代码
            return count;
        } finally {
            readLock.unlock();
        }
    }
    public void writeByWriteLock() throws InterruptedException {
        //获取/释放悲观读锁示意代码
        try {
            writeLock.lock();
            //省略业务相关代码
             count+=1;
        } finally {
            writeLock.unlock();
        }
    }


    public int writeByStampLock() throws InterruptedException {
        //获取/释放悲观读锁示意代码
        long stamp = sl.writeLock();
        try {
            //省略业务相关代码
            count+=1;
        } finally {
            sl.unlockWrite(stamp);
        }
        return count;
    }

}
