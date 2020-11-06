package com.example.train.week2.client.hello;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:49 on 2020/11/4
 * @version V0.1
 * @classNmae HelloClientApplication
 */
public class HelloClientApplication {

    public static void main(String[] args) throws Exception {
        HelloClient client = new HelloClient("localhost",8801);
        client.start();
    }
}
