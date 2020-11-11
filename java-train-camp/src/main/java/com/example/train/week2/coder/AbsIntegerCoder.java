package com.example.train.week2.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:54 on 2020/11/5
 * @version V0.1
 * @classNmae AbsIntegerCoder
 */
@Slf4j
public class AbsIntegerCoder extends ByteToMessageCodec<ByteBuf> {



    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception {
        log.info("AbsIntegerCoder encode start...");
         out.writeBytes(msg);
        log.info("AbsIntegerCoder encode end...");
    }


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.info("AbsIntegerCoder decode List start...");
        while (in.readableBytes() >= 4) {
            int value = Math.abs(in.readInt());
            out.add(value);
        }
        log.info("AbsIntegerCoder decode List end out.size={}",out.size());
    }
}
