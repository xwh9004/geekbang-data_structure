package com.example.concurrent;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:38 on 2020/3/30
 * @version V0.1
 * @classNmae ThreadLocalTest
 */
public class ThreadLocalTest {

    @Test
    public void thread_local() throws InterruptedException {
        ArrayList formats = new ArrayList();
        final DateFormat format3 = null;

        Thread t1 = new Thread(() -> {
            DateFormat format1  = SafeDateFormat.get();
            formats.add(format1);
            System.out.println(format1);
        });
        Thread t2 = new Thread(() -> {
            DateFormat format2  = SafeDateFormat.get();
            formats.add(format2);
            System.out.println(format2.toString());
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(SafeDateFormat.get());
        formats.add(SafeDateFormat.get());

        System.out.println(formats.get(0)==formats.get(1));
        System.out.println(formats.get(0)==formats.get(2));
        System.out.println(formats.get(1)==formats.get(2));
    }
}
