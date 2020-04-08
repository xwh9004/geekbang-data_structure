package com.example.concurrent;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 11:02 on 2020/4/8
 * @version V0.1
 * @classNmae Singleton
 */
public class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance(){
        if (instance ==null){
            synchronized (Singleton.class){
                if(instance ==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
