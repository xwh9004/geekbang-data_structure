package com.example.train.week2.server.echo;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:18 on 2020/11/4
 * @version V0.1
 * @classNmae AbsServerApplication
 */
public class EchoServerApplication {

    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.err.println(
//                    "Usage: " + EchoServer.class.getSimpleName() +
//                            " <port>");
//        }
//        int port = Integer.parseInt(args[0]);
        int port = 8080;
        new EchoServer(port).start();
    }
}
