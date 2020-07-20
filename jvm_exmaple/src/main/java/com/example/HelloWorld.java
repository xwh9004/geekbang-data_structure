package com.example;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:00 on 2020/4/28
 * @version V0.1
 * @classNmae HelloWorld
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("maxMemory "+Runtime.getRuntime().maxMemory()/(1024*1024)+ "M");
        System.out.println("totalMemory "+Runtime.getRuntime().totalMemory()/(1024*1024)+ "M");
        System.out.println("freeMemory "+Runtime.getRuntime().freeMemory()/(1024*1024)+ "M");
        System.out.println("hello world");
    }
}
