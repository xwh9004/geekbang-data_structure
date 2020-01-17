package com.example.ch41;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:13 on 2020/1/9
 * @version V0.1
 * @classNmae DynamicStrategy
 */
public class DynamicStrategy {
    /**
     * 我们有 3 种不同的硬币，1 元、3 元、5 元，我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）
     *
     * @return
     */
    public int payByCoin(int w) {
        int[] res = new int[w];
        res[0] = 1;
        res[1] = 2;
        res[2] = 1;
        res[3] = 2;
        res[4] = 1;

        for (int i = 5; i < w; i++) {
            res[i] = min(res[i - 1], res[i - 3], res[i - 5]) + 1;
        }

        return res[w - 1];
    }

    public int min(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    /**
     * 我们有一个数字序列包含 n 个不同的数字，如何求出这个序列中的最长递增子序列长度？
     * 比如 2, 9, 3, 6, 5, 1, 7 这样一组数字序列，它的最长递增子序列
     * 就是 2, 3, 5, 7，所以最长递增子序列的长度是 4。
     *
     * @param array
     * @return
     */
    public int longestIncreaseSubArrayDP(int[] array) {
        int len = array.length;
        int[] state = new int[len];
        state[0] = 1;   //state[i] 表示 第i个元素在前i个元素中的第几大元素
        for (int i = 1; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(array[j]<array[i]){
                    if (state[j] > max) max = state[j];
                }
            }
            state[i]=max+1;
        }
        int result = 0;
        for (int i = 0; i < state.length; i++) {
            if (state[i] > result) result = state[i];
        }

        return result;
    }

    public static void main(String[] args) {
        DynamicStrategy strategy = new DynamicStrategy();
//        System.out.println(strategy.payByCoin(19));

        int[] arr ={2,9,3,6,5,1,7};
        System.out.println(strategy.longestIncreaseSubArrayDP(arr));
    }
}
