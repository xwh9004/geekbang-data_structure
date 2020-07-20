package com.example.ch07;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:31 on 2020/4/7
 * @version V0.1
 * @classNmae Foo
 */
public class Foo {

    public void foo(Object lock) {
        synchronized (lock) {
            lock.hashCode();
        }
    }
}
