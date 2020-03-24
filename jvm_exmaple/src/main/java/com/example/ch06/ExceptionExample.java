package com.example.ch06;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:50 on 2020/1/15
 * @version V0.1
 * @classNmae ExceptionExample
 */
public class ExceptionExample {

    /**
     * 打印出来的异常栈轨迹并非 throw 语句的位置，而是新建异常的位置。
     * @param args
     * @throws MyException
     */
    @SuppressWarnings("")
    public static void main(String[] args) throws Exception {


        System.out.println("run ok...");
        try {
            throw new MyException();
        }catch (MyException e){
            throw new Exception();
        }finally {
            System.out.println("run finally...");
        }



    }


}

class MyException extends Exception {

    public MyException() {

    }
}