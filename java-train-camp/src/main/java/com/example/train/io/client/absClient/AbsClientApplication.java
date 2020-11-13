package com.example.train.io.client.absClient;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:26 on 2020/11/4
 * @version V0.1
 * @classNmae FileClientApplication
 */
public class AbsClientApplication {

    public static void main(String[] args) throws InterruptedException {
//        if (args.length != 2) {
//            System.err.println(
//                    "Usage: " + FileClient.class.getSimpleName() +
//                            " <host> <port>");
//            return;
//        }
//        String host = args[0];
//        int port = Integer.parseInt(args[1]);
        String host="localhost";
        int port = 8080;
        new AbsClient(host, port).start();
    }
}
