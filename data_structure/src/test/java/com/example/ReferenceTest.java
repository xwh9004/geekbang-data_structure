package com.example;

import java.lang.ref.SoftReference;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 23:57 on 2020/1/11
 * @version V0.1
 * @classNmae ReferenceTest
 */
public class ReferenceTest {

    public static void main(String[] args) {
        Integer number = new Integer(1);
        number = null;
        System.out.println(number.intValue());

        Integer num = new Integer(2);

//        SoftReference<Integer> s

    }
}
