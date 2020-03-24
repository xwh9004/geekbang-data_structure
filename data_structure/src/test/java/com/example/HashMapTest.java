package com.example;

import java.util.HashMap;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:47 on 2020/1/21
 * @version V0.1
 * @classNmae HashMapTest
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        long start = System.currentTimeMillis();
        for (long i = 0;i<100000000;i++){
            map.put(i,i);
        }
        System.out.println("ms:"+(System.currentTimeMillis()-start));
        System.out.println(map.size());
    }
}
