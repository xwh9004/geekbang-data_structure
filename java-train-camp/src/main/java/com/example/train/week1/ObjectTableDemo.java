package com.example.train.week1;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * <p><b>Description:</b>
 *    <ul>
 *        <li>Object Head 对象头分布</li>
 *           1 - 64  是 mark word
 *          65- 96  是 Class.class 类对象指针（元数据）
 *          97 -128 是 填充字或者数组长度（如果对象是数组的话）
 *          如果是数组的话，接下来是数组引用地址  一个reference 4bytes
 *    </ul>
 *
 *
 *
 *
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:14 on 2020/10/29
 * @version V0.1
 * @classNmae ObjectTableDemo
 */
public class ObjectTableDemo {


    public static void main(String[] args) {
//        A a = new A();
//        System.out.println("-----------对象 A-------------------");
//        printObjectTable(a);
//        A a1 = new A();
//        System.out.println("-----------对象 A1-------------------");
//        printObjectTable(a1);
//        B b = new B();
//        b.b1 =1;
//        b.b2 =3;
//        System.out.println("-----------对象 B-------------------");
//        printObjectTable(b);
//        B[] b_arr = new B[3];
//        b_arr[0] = new B();
//        b_arr[1] = new B();
//        b_arr[2] = new B();
//        System.out.println("-----------对象 B[]-------------------");
//        printObjectTable(b_arr);
//        C c = new C();
//        c.a =a;
//        c.b =b;
//        System.out.println("-----------对象 C-------------------");
//
//        printObjectTable(c);
//
        Son son = new Son();
        System.out.println("-----------对象 Son-------------------");

        printObjectTable(son);

    }

    static void printObjectTable(Object o){

        //查看对象内部信息
        System.out.println("---->对象内部（对象头）信息 ："+ ClassLayout.parseInstance(o).toPrintable());
        //查看对象外部信息
        System.out.println("---->对象外部(实例)信息 ："+ GraphLayout.parseInstance(o).toPrintable());
        //查看对象总大小
        System.out.println("---->对象总大小 ："+ GraphLayout.parseInstance(o).totalSize());
    }

    static class A{
    }

    static class B{
        int b1;
        int b2;

    }
    static class C{
        A a ;
        B b;
    }

    static class Parent{
        String name ="P11";
    }
    static class Son extends Parent{
        String name ="Son1";
    }

}
