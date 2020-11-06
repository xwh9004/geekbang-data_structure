package com.example.train.week2.client.hello;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import lombok.extern.slf4j.Slf4j;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:24 on 2020/11/3
 * @version V0.1
 * @classNmae HelloClientInboundHandler
 */
@Slf4j
public class HelloClientInboundHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
//        FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,"/");
//        ctx.channel().write(request);
//        ctx.channel().flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
//       ctx.flush();
//       ctx.close();
        log.info("channelReadComplete ctx={}",ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                if(msg instanceof FullHttpResponse){
            FullHttpResponse response = (FullHttpResponse)msg;
            log.info("globalSeqNo="+response.headers().get("globalSeqNo"));
            try {
                int length =response.content().readableBytes();
                byte[] body =new byte[length];
                response.content().readBytes(body);
//                log.info("endpointResponse ={}",new String(body));
//                ctx.writeAndFlush(msg);
                ctx.write(msg);
            }catch (Exception e){
               e.printStackTrace();
            }finally {
//                ReferenceCountUtil.release(msg);
            }
        }
    }
}
