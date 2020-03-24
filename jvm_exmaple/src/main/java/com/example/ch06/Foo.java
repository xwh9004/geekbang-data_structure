package com.example.ch06;

import java.io.Closeable;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:17 on 2020/1/15
 * @version V0.1
 * @classNmae Foo
 */
public class Foo {
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test() {
        for (int i = 0; i < 10; i++) {
            try {
                tryBlock = 0;
                if (i < 5) {
                    continue;
                } else if (i < 8) {
                    break;
                } else {
                    return;
                }
            } catch (Exception e) {
                catchBlock = 1;
            } finally {
                finallyBlock = 2;
                System.out.println(i);
            }
        }
        methodExit = 3;
    }
//
//    public static void main(String[] args) {
//        new Foo().test();
//    }
}
