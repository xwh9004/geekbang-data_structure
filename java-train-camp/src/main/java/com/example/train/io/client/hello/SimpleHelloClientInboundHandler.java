package com.example.train.io.client.hello;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
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
public class SimpleHelloClientInboundHandler extends SimpleChannelInboundHandler<FullHttpResponse> {
    /**
     * Is called for each message of type {@link FullHttpResponse}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param msg the message to handle
     * @throws Exception is thrown if an error occurred
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpResponse msg) throws Exception {
        log.info("globalSeqNo="+msg.headers().get("globalSeqNo"));
        int length =msg.content().readableBytes();
        byte[] body =new byte[length];
        msg.content().readBytes(body);
        log.info("endpointResponse ={}",new String(body));
        ctx.writeAndFlush(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);

        log.info("SimpleHelloClientInboundHandler channelReadComplete ");
        ctx.channel().close();

    }
}
