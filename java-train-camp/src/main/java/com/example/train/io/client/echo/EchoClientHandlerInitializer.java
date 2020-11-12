package com.example.train.io.client.echo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:31 on 2020/11/12
 * @version V0.1
 * @classNmae EchoClientHandlerInitializer
 */
@Slf4j
public class EchoClientHandlerInitializer extends ChannelInitializer {


    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast(  new EchoClientHandler());
        ch.pipeline().addLast(new IdleStateHandler(0, 0, 2, TimeUnit.SECONDS));
        ch.pipeline().addLast(new ReadTimeoutHandler(1){
            @Override
            protected void readTimedOut(ChannelHandlerContext ctx) throws Exception {
                log.error("Time Out!!!");
                super.readTimedOut(ctx);
            }
        });
    }
}
