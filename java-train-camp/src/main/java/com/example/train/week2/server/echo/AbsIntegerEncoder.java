package com.example.train.week2.server.echo;

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
 * @classNmae AbsIntegerEncoder
 */
@Slf4j
public class AbsIntegerEncoder extends ByteToMessageCodec<ByteBuf> {



    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception {
        log.info("AbsIntegerEncoder decode");
        while (msg.readableBytes() >= 4) {
            int value = Math.abs(msg.readInt());
            out.writerIndex(value);
        }
    }


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.info("AbsIntegerEncoder decode List start");
        while (in.readableBytes() >= 4) {
            int value = Math.abs(in.readInt());
            out.add(value);
        }
        log.info("AbsIntegerEncoder decode List end");
    }
}
