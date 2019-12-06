package com.example;

/**
 * <p><b>Description:</b>  (摘录于极客时间 数据结构与算法之美 ch27递归树 )
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:42 on 2019/12/5
 * @version V0.1
 * @classNmae Permutation
 */
public class Permutation {

    /**
     * n数组长度
     * 将要排列的数据用数组表示是的代码实现变得简单容易
     * @param data
     * @param n
     * @param k    表示要处理的子数组的数据个数
     */
    public static void printPermutations(char[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; i++) {
            /**
             * 确定最后一位数
             */
            char tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;

            printPermutations(data, n, k - 1);
            /**
             * 归位数据
             */
            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }




    public static void main(String[] args) {
        char[] chars=new char[]{'a','b','c','d'};

        printPermutations(chars, chars.length,chars.length);

    }
}
