package com.example.train.aop;

public class School implements ISchool {
    @Override
    public void ding() {
        System.out.println("dingding.... !");
    }

    static void dang(){
        System.out.println("dangdang.... !");
    }
}
