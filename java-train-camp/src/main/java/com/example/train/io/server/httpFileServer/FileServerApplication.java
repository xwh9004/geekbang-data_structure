package com.example.train.io.server.httpFileServer;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:08 on 2020/11/13
 * @version V0.1
 * @classNmae FileServerApplication
 */
public class FileServerApplication {

    public static void main(String[] args) throws Exception {

        FileServer server = new FileServer(8080);
        server.start();

    }
}
