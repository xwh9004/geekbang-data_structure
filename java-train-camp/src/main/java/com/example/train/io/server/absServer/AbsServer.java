package com.example.train.io.server.absServer;

import com.example.train.io.coder.AbsIntegerCoder;
import com.example.train.io.coder.AbsIntegerDecoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
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
public class AbsServer {

    private int port;

    public AbsServer(int port){
        this.port = port;
    }

    public void start() throws Exception {
        final AbsServerInboundHandler serverHandler = new AbsServerInboundHandler();
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                    .option(ChannelOption.SO_SNDBUF, 32 * 1024)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>(){
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(new AbsIntegerDecoder());
                            ch.pipeline().addLast(new AbsIntegerCoder());
                            ch.pipeline().addLast(serverHandler);

                        }
                    });
            ChannelFuture f = b.bind().sync();
            log.info("开启netty http服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');
            f.channel().closeFuture().addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    System.out.println("Server operationComplete: " );
                }
            });
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
