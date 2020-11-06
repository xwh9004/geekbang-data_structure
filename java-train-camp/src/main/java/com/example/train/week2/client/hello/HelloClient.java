package com.example.train.week2.client.hello;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import lombok.extern.slf4j.Slf4j;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:23 on 2020/11/3
 * @version V0.1
 * @classNmae HelloClient
 */
@Slf4j
public class HelloClient {

    private String host;

    private int port;

    public HelloClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
//                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(new HttpClientCodec())
                                    .addLast(new HttpObjectAggregator(1024 * 10 * 1024))
                                    .addLast( new HelloClientInboundHandler())
                            .addLast(new SimpleHelloClientOutboundHandler());
                        }
                    });
            ChannelFuture f = b.connect("localhost",8801).sync();
            log.info("ChannelFuture f = {}",f.toString());


            for(int i=0;i<1;i++){
                FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,"/");

                f.channel().writeAndFlush(request);
            }
            f.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully().sync();
            log.info("EchoClient shutdownGracefully!!");
        }
    }

}
