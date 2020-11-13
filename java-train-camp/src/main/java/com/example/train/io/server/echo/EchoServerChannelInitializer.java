package com.example.train.io.server.echo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:49 on 2020/11/12
 * @version V0.1
 * @classNmae EchoServerChannelInitializer
 */
@Slf4j
public class EchoServerChannelInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        ch.pipeline().addLast(new EchoServerInboundHandler());
        pipeline.addLast(
                new IdleStateHandler(0, 0, 2, TimeUnit.SECONDS));

        //ReadTimeoutHandler 如果长时间没有数据进来 会关闭channel
        //貌似用在客户端不起作用
        ch.pipeline().addLast(new ReadTimeoutHandler(1){
            @Override
            protected void readTimedOut(ChannelHandlerContext ctx) throws Exception {
                log.error("Time Out!!!");
                super.readTimedOut(ctx);
            }
        });
        pipeline.addLast(new HeartbeatHandler());
    }
}
