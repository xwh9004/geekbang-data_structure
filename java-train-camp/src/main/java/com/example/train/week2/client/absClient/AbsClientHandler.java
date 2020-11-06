package com.example.train.week2.client.absClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:27 on 2020/11/4
 * @version V0.1
 * @classNmae EchoClientHandler
 */
@Slf4j
public class AbsClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//         ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!",
//                        CharsetUtil.UTF_8));
        ByteBuf buf = Unpooled.buffer();
        for (int i = 1; i < 10; i++) {
            buf.writeInt(i * (-1));
        }
        ctx.writeAndFlush(buf);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("EchoClientHandler channelRead ...");
        super.channelRead(ctx, msg);
    }

    @Override
    public boolean acceptInboundMessage(Object msg) throws Exception {
       boolean acceptable = super.acceptInboundMessage(msg);
        log.info("EchoClientHandler acceptInboundMessage acceptable={}",acceptable);
        return super.acceptInboundMessage(msg);
    }

    /**
     * Is called for each message of type {@link }.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param msg the message to handle
     * @throws Exception is thrown if an error occurred
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        log.info("channelRead0 ");
        StringBuilder received =new StringBuilder();
        while(msg.readableBytes()>=4){
           int value = msg.readInt();
           received.append(value);
        }
        log.info("received value = {}",received.toString());
//        System.out.println(
//                "Client received: " + in.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        log.info("EchoClientHandler channelReadComplete");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
