package com.example.concurrent;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:37 on 2020/4/27
 * @version V0.1
 * @classNmae Fibonacci
 */
public class Fibonacci {



    public long f(int n) {
        if (n <= 2) {
            return 1;
        }
        return f(n-1)+f(n-2);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci();
        int n =20;
        long f= fibonacci.f(n);
        System.out.println(n +" fibonacci = "+f);
        System.out.println("consume " + (System.currentTimeMillis() - start) + " ms");
    }
}
