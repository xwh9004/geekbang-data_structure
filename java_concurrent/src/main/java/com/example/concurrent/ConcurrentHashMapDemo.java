package com.example.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:56 on 2020/4/26
 * @version V0.1
 * @classNmae ConcurrentHashMapDemo
 */
public class ConcurrentHashMapDemo {




    public static void main(String[] args) {

//        ConcurrentHashMap map = new ConcurrentHashMap();
//        System.out.println(map.put(new Person(1),String.valueOf(11)));
//        System.out.println(map.put(new Person(1),String.valueOf(12)));
//        System.out.println();

        ConcurrentLinkedQueue queue =  new ConcurrentLinkedQueue();
        queue.add(new Person(1));
        queue.add(new Person(2));
    }


}
