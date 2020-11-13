package com.example.train.io.client.httpFileClient;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:26 on 2020/11/4
 * @version V0.1
 * @classNmae FileClientApplication
 */
public class FileClientApplication {

    public static void main(String[] args) throws InterruptedException {

        String host="localhost";
        int port = 8080;
        new FileClient(host, port).start();
    }
}
