package com.example.train.week2;

import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.URL;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:12 on 2020/10/26
 * @version V0.1
 * @classNmae MyGateWay
 */
public class MyGateWay {

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.New(new URL("http://localhost:8801"));
//            client.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
