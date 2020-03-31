package com.example.concurrent;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:25 on 2020/3/31
 * @version V0.1
 * @classNmae BalkingDemo
 */
public class BalkingDemo {

     boolean inited = false;
    int count = 0;

    void init() {
        if (inited) {
            return;
        }
        inited = true; //计算count的值
        count = calc();
    }

    public int getCount() {

        return count;
    }

    public int calc(){

        return count+1;
    }
}
