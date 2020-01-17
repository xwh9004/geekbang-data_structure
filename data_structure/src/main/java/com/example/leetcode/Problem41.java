package com.example.leetcode;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 23:02 on 2020/1/11
 * @version V0.1
 * @classNmae Problem41
 */
public class Problem41 {

    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     * eg.
     * 输入: [1,2,0]
     * 输出: 3
     * <p>
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            if (nums[0] != 1) {
                return 1;
            } else {
                return 2;
            }
        }

        //用 1 替换负数，0， 和大于 n 的数, 在转换以后，nums 只会包含 正数
        //
        int count = 0; //计算被替换的个数
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
                count++;
            }
        }

        //记录替换后的正整数数组中出现的正整数,使用数组下标记录
        for (int i = 0; i < len; i++) {
            int a = Math.abs(nums[i]);
            // 如果发现了一个数字 a - 改变第 a 个元素的符号
            // 注意重复元素只需操作一次
            if (a == len)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }

        // 现在第一个正数的下标
        // 就是第一个缺失的数
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return len;

        return len + 1;
    }


    public static void swap(int i, int j, int[] nums) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {3,4,-1,1};
//        int[] nums = {1,2,0};
//        int[] nums = {7,8,9,11,12};
        long[] nums = {3, 4, -1, -2, 1, 5, 16, 0, 2, 0};
        long[] nums_1 = {-1, 4, 2, 1, 9, 10};
//        int[] nums = {2,1,1};
//        System.out.println(firstMissingPositive(nums));
//        System.out.println(firstMissingPositive(nums_1));

        System.out.println(cutRopeMaxAcct(5));

    }


    public static long cutRopeMaxAcct(int m) {
        if(m<5){
            return m;
        }
        long[] result = new long[m+1];
        result[0] = 0L;
        result[1] = 1L;
        result[2] = 2L;
        result[3] = 3L;
        result[4] = 4L;
        for (int i=5;i<=m;i++){
            long max =0;
            for (int j=1;j<=i/2;j++){
                max =max(result[j]*result[i-j],max);
            }
            result[i] = max;
        }
        return result[m];

    }

    public static long max(long a,long b){
        return Math.max(a,b);
    }
}
