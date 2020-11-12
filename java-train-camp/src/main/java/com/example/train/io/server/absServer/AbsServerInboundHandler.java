package com.example.train.io.server.absServer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:14 on 2020/11/4
 * @version V0.1
 * @classNmae EchoServerHandler
 */
@Slf4j
@ChannelHandler.Sharable
public class AbsServerInboundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        log.info("Server channelActive: " );
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.info("Server channelInactive! " );
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buff = Unpooled.buffer();
        if(msg instanceof Integer){
            Integer value =(Integer)msg;
            buff.writeInt(value.intValue());
            ctx.writeAndFlush(buff);
            log.info("absServer send "+ value );
        }

//         ByteBuf in = (ByteBuf) msg;
//        Integer in = (Integer) msg;
//        log.info("Server received: " +in);
//        log.info("Server received: " + in.toString(CharsetUtil.UTF_8));
//        ctx.writeAndFlush(in);


    }


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        log.info("Server channelRegistered! " );
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
        log.info("Server channelWritabilityChanged! " );
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

//        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
//                .addListener(ChannelFutureListener.CLOSE);
        ctx.flush();
        ctx.close();
        log.info("Server channelReadComplete! " );
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
        log.info("Server channelUnregistered! " );
    }
}
