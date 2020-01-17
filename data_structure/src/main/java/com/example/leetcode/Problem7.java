package com.example.leetcode;

/**
 * <p><b>Description:</b>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 输入: 120
 * 输出: 21
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:23 on 2020/1/15
 * @version V0.1
 * @classNmae Problem5
 */
public class Problem7 {

    /**
     * 除10求模
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int max =Integer.MAX_VALUE/10;
        int min =Integer.MIN_VALUE/10;
        int quotient = x;
        int res = 0;
        while (x != 0) {
            if(res>max||res<min){
               return 0;
            }
            int modulus =x % 10 ;
            res = res*10 +modulus ;
            x = x / 10;

        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(-2147483648));

    }
}
