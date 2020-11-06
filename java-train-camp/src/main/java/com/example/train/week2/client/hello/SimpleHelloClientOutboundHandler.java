package com.example.train.week2.client.hello;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:54 on 2020/11/4
 * @version V0.1
 * @classNmae SimpleHelloClientInboundHandler
 */
@Slf4j
public class SimpleHelloClientOutboundHandler extends ChannelOutboundHandlerAdapter {


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx, msg, promise);
        log.info("SimpleHelloClientOutboundHandler write");
    }
}
