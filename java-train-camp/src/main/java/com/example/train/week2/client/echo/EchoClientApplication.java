package com.example.train.week2.client.echo;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:26 on 2020/11/4
 * @version V0.1
 * @classNmae EchoClientApplication
 */
public class EchoClientApplication {

    public static void main(String[] args) throws InterruptedException {
//        if (args.length != 2) {
//            System.err.println(
//                    "Usage: " + EchoClient.class.getSimpleName() +
//                            " <host> <port>");
//            return;
//        }
//        String host = args[0];
//        int port = Integer.parseInt(args[1]);
        String host="localhost";
        int port = 8080;
        new EchoClient(host, port).start();
    }
}
