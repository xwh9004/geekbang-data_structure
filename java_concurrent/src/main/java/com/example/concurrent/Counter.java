package com.example.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:14 on 2020/3/30
 * @version V0.1
 * @classNmae Counter
 */
public class Counter {

    public long count = 0;


    void add10m_unsafe() {
        int idx = 0;
        while (idx++ < 10000000) {
            count += 1;
        }
    }
    AtomicLong count_safe = new AtomicLong(0);
    void add10m_safe() {
        int idx = 0;
        while (idx++ < 10000000) {
            count_safe.getAndIncrement();
        }
    }

}
