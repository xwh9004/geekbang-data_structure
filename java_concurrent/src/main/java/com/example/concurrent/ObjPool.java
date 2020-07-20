package com.example.concurrent;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:13 on 2020/3/26
 * @version V0.1
 * @classNmae ObjPool
 */
public class ObjPool<T, R> {

    final List<T> pool;
    // 用信号量实现限流器
    final Semaphore sem;


    // 构造函数
    ObjPool(int size, T t) {
        //此处不能使用ArrayList  因为ArrayList add ,remove方法非线程安全
        //应使用Vector
        pool = new Vector<T>() {
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建对象池
        ObjPool<Long, String> pool = new ObjPool<Long, String>(10, 2L);
        // 通过对象池获取t，之后执行
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 1000; i++) {
                    pool.exec(t -> {
                        return t.toString();
                    });
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 1000; i++) {
                    pool.exec(t -> {
                        return t.toString();
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

    // 利用对象池的对象，调用func
    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }
}

