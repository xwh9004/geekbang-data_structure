package com.example.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:03 on 2020/3/26
 * @version V0.1
 * @classNmae ReadWriteLockDemo
 */
public class ReadWriteLockDemo {

    public HashMap<String, String> data = new HashMap<>();

    public Cache<String, String> cache = new Cache<>();

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        demo.dataGenerate();
        IntStream.rangeClosed(0, 7).forEach(i -> {

                    new Thread(() -> {
                        for (int j = 0; j < 5; j++) {
                            String key = "key_" + ((i >> 1) * 5 + j);
                            System.out.println(key + "=" + demo.get(key));
                        }
                    }).start();
                }
        );
    }

    public void dataGenerate() {
        IntStream.rangeClosed(0, 19).forEach(i -> {
            data.put("key_" + i, "value_" + i);
//            cache.put("key_" + i, "value_" + i);  //一次性加载数据
        });
    }

    public String readData(String key) {
        System.out.println("read from data where key = " + key);
        return data.get(key);
    }

    public String get(String key) {

        return cache.get(key);
    }

    class Cache<K, V> {
        final Map<K, V> m =
                new HashMap<>();
        final ReadWriteLock rwl =
                new ReentrantReadWriteLock();
        // 读锁
        final Lock r = rwl.readLock();
        // 写锁
        final Lock w = rwl.writeLock();

     /*   // 读缓存
        V get(K key) {
            r.lock();
//            data
            try {
                return m.get(key);
            } finally {
                r.unlock();
            }
        }*/

        V get(K key) {
            //锁升级,导致死锁
//          return  upgradeLock(key);
            //正常读取
            return normalGet(key);

        }

        V normalGet(K key) {
            V v = null;
            //读缓存
            r.lock();
            try {
                v = m.get(key);
            } finally {
                r.unlock();
            }
            //缓存中存在，返回
            if (v != null) {
                return v;
            }
            //缓存中不存在，查询数据库
            w.lock();
            try {
                //再次验证
                //其他线程可能已经查询过数据库
                v = m.get(key);
                if (v == null) {
                    //查询数据库
                    String keyS = (String) key;
                    v = (V) readData(keyS);
                    m.put(key, v);
                }
            } finally {
                w.unlock();
            }
            return v;
        }


        /**
         * 读锁不能升级为写锁
         * @param key
         * @return
         */
        V upgradeLock(K key) {
            V v = null;
            r.lock();     //可共享
            try {
                v = m.get(key);
                if (v == null) {
                    w.lock();
                }
                try {
                    //再次验证并更新缓存 //省略详细代码
                    //再次验证
//                //其他线程可能已经查询过数据库
                    v = m.get(key);
                    if (v == null) {
                        //查询数据库
                        String keyS = (String) key;
                        v = (V) readData(keyS);
                        m.put(key, v);
                    }

                } finally {
                    w.unlock();
                }

            } finally {
                r.unlock();
            }
            return v;
        }

        // 写缓存
        V put(K key, V value) {
            w.lock();
            try {
                return m.put(key, value);
            } finally {
                w.unlock();
            }
        }
    }
}
