package com.example.train.io.server.fileUploadServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:18 on 2020/11/4
 * @version V0.1
 * @classNmae EchoServer
 */
@Slf4j
public class FileUploadServer {

    private int port;

    public FileUploadServer(int port){
        this.port = port;
    }

    public void start() throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new FileUploadServerChannelInitializer());
            ChannelFuture f = b.bind().sync();
            log.info("开启FileUploadServer服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');

            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
