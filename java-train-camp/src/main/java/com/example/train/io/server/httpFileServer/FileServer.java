package com.example.train.io.server.httpFileServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:08 on 2020/11/13
 * @version V0.1
 * @classNmae FileServer
 */
@Slf4j
public class FileServer {


    private int port;


    public FileServer(int port){
        this.port = port;
    }

    public void start() throws Exception{
        //定义接收连接的eventLoop
        EventLoopGroup bossGroup = new NioEventLoopGroup(3);
        //定义处理 接收链接EventLoop 分发的连接
        EventLoopGroup workerGroup = new NioEventLoopGroup(100);

        //定义服务端启动引导类
        ServerBootstrap bootstrap = new ServerBootstrap();

        try{
            //服务端参数配置
            bootstrap
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                    .option(ChannelOption.SO_SNDBUF, 32 * 1024)
                    .option(EpollChannelOption.SO_REUSEPORT, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            //组装eventLoop channel等组件
            bootstrap.group(bossGroup,workerGroup)   //组装eventLoop
                    .channel(NioServerSocketChannel.class)  //指定使用NIOServerSocketChannel
                    .handler(new LoggingHandler(LogLevel.INFO))  //添加bossGroup 日志处理handler
                    .childHandler(new FileServerChannelInitializer()) ;
            //bind and listen specific port ,block util bind successful then get  channel
            Channel ch = bootstrap.bind(port).sync().channel();
            log.info("FileServer，监听地址和端口为 http://127.0.0.1:" + port + '/');
            //block util channel closed
            ch.closeFuture().sync();
        }finally {
            //优雅的关闭EventLoop
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            log.info("FileServer shutdownGracefully");
        }


    }
}
