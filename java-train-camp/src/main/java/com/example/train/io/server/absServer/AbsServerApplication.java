package com.example.train.io.server.absServer;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:18 on 2020/11/4
 * @version V0.1
 * @classNmae AbsServerApplication
 */
public class AbsServerApplication {

    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.err.println(
//                    "Usage: " + EchoServer.class.getSimpleName() +
//                            " <port>");
//        }
//        int port = Integer.parseInt(args[0]);
        int port = 8080;
        new AbsServer(port).start();
    }
}
