package com.example.concurrent;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:50 on 2020/4/8
 * @version V0.1
 * @classNmae SwitchTest
 */
public class SwitchTest {

    public static void main(String[] args) {
        String value = "c";
        String result ;
        switch (value){
            case "A":
                result = "a";
                break;
            case "B":
                result = "b";
                break;
             default:
                 result="null";
                 break;
        }
    }
}
