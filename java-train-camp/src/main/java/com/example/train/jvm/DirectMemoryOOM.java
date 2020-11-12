package com.example.train.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * <p><b>Description:</b>
 * <p><b>Company:</b>
 * VM Args： -Xmx20M-XX:MaxDirectMemorySize=10M
 * 没有产生heap dump文件
 * @author created by Jesse Hsu at 14:06 on 2020/10/28
 * @version V0.1
 * @classNmae DirectMemoryOOM
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
