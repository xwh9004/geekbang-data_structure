package com.example.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:37 on 2020/3/30
 * @version V0.1
 * @classNmae SafeDateFormat
 */
public class SafeDateFormat {

    //定义ThreadLocal变量
    static final ThreadLocal tl =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    static DateFormat get() {
        System.out.println("thread name:"+Thread.currentThread().getName());
        return (DateFormat) tl.get();
    }
}
