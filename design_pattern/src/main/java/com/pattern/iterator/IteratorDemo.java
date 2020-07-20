package com.pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:24 on 2020/4/13
 * @version V0.1
 * @classNmae IteratorDemo
 */
public class IteratorDemo {

    public static void main(String[] args) {
        List names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        Iterator iterator1 = names.iterator();
        Iterator iterator2 = names.iterator();
        System.out.println(iterator1.next());
        iterator1.remove();
        System.out.println(iterator2.next()); // 运行结果？
       }
    }

