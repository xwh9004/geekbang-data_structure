package com.example;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Xu at 15:41 on 2019/11/26
 * @version V0.1
 * @classNmae BinarySearch
 */
public class BinarySearch {


    /**
     * 查找第一等于给定值的位置
     * @param a
     * @param value
     * @return 数组下标
     */
    public static int firstIndexOf(int[] a,int value){
        int low = 0;
        int len =a.length;
        int high = len-1;
        int mid;
        while(low<=high){
             mid = low + ((high - low) >> 1);
             if(a[mid]>=value){
                 high =mid -1;
             }else{
                 low = mid+1;
             }
        }
        if(low<len&&a[low]==value)
            return low;
        return -1;

    }
    public static int lastIndexOf(int[] a,int value){
        int len =a.length;
        int low = 0;
        int high = a.length-1;
        int mid ;
        while(low<=high){
            mid = low + ((high - low) >> 1);
            if(a[mid]>value){
                high =mid -1;
            }else{
                low = mid+1;
            }
        }
        if(high<len&&a[high]==value)
            return high;
        return -1;

    }

    public int lastIndexOf_v2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 如果精度太高，是进入死循环 scale 最高设置为10
     * @param s
     * @param scale
     * @return
     */
    public static double sqrt(double s,int scale){
        if(scale>10){
            scale =10;
        }
         double root =0;
         //查找整数
        double low = 0;
        double high = s;
        double mid =0;
        double d =1;
        double res =0;
        for (int i=0;i<=scale;i++){
            while (low<=high){
                mid = low + (high - low)/2;
                mid =Double.valueOf( String.format("%."+i+"f", mid));
                if(mid*mid==s){
                    return mid;
                }
                if(mid*mid<s){
                    low = mid+d;
                }
                if(mid*mid>s){
                    high = mid-d;
                }
            }
            low =mid-d;
            high =mid+d;
            d*=0.1;
        };
         return mid;
    }


    public static void main(String[] args) {
       int[] arr = new int[]{1,7,7,7,7,7,7,7,8,13,13,18};
       System.out.println(firstIndexOf(arr,4));
       System.out.println(lastIndexOf(arr,19));
    }
}
