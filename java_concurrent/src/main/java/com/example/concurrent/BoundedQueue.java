package com.example.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:10 on 2020/4/26
 * @version V0.1
 * @classNmae BoundedQueue
 */
public class BoundedQueue<T> {

    public ReentrantLock lock = new ReentrantLock();

    public Condition notEmpty = lock.newCondition();

    public Condition notFull = lock.newCondition();

    private Object[] items;

    private int addIndex, removeIndex, count;

    public BoundedQueue(int size) {
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {

        lock.lock();
        try {
            if (items.length == count) {
                notFull.await();
            }
            items[addIndex] = t;
            if (++addIndex == items.length)
                addIndex = 0;
            count++;
            notEmpty.signal();
        }finally{
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BoundedQueue queue = new BoundedQueue(5);
        queue.add(1);
    }
}
