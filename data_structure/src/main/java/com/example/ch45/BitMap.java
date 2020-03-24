package com.example.ch45;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:54 on 2020/1/20
 * @version V0.1
 * @classNmae BitMap
 */

public class BitMap { // Java中char类型占16bit，也即是2个字节
    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits/16+1];
    }

    public void set(int k) {
        if (k > nbits) return;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nbits) return false;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }


    public static void main(String[] args) {
        //简单的利用bitMap排序,假设无重复，有重复的话需要对bitMap在维护一个列表
        int[] arrays = {1,8,6,9,10,7,2,3,15,5};
        BitMap bm = new BitMap(16);
        int len = arrays.length;
        for(int i=0;i<len;i++){
            bm.set(arrays[i]);
        }

        for(int i=0;i<bm.nbits;i++){
           if(bm.get(i)){
               System.out.print(i+" ");
           }
        }
    }
}
