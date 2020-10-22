package com.example.train;

import java.util.Arrays;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:07 on 2020/10/22
 * @version V0.1
 * @classNmae ForByteCode
 */
public class ForByteCode {
    public static void main(String[] args) {
        int[] a ={1,3,4,5,6,7,10};
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        for(int b:a){
            System.out.println(b);
        }
        Arrays.stream(a).forEach(System.out::println);
    }
}



