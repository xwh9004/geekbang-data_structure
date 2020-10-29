package com.example.train.week2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:59 on 2020/10/29
 * @version V0.1
 * @classNmae HttpConnectHandler
 */
@Slf4j
public class HttpConnectHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("channelActive Client {} connected " , ctx.channel().remoteAddress());
        super.channelActive(ctx);
    }
}
