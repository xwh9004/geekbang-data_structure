package com.example.train.week1;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:43 on 2020/10/28
 * @version V0.1
 * @classNmae StringHello
 */
public class StringHello {
    public static void main(String[] args) throws InterruptedException {
        String hello = "Hello String";
        String hello_1 = "Hello String Java";
//        System.out.println(hello);

        inter("Demo");
    }

    static void inter(String str)throws InterruptedException{
        Thread.sleep(30000);
        str.intern();
    }
}
