package com.example.train.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.junit.Test;

import java.nio.charset.Charset;

import static org.junit.Assert.assertTrue;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:33 on 2020/11/12
 * @version V0.1
 * @classNmae LengthFieldBasedFrameDecoderTest
 */
public class LengthFieldBasedFrameDecoderTest {
    @Test
    public void test(){
        ByteBuf buf = Unpooled.buffer();
        String msg = "Hello, World";
        buf.writeByte((byte)1);
        buf.writeByte((byte)49);

        buf.writeBytes(msg.getBytes());
        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(
                new LengthFieldBasedFrameDecoder(256,0,1,1,2));

        assertTrue(channel.writeInbound(input.retain()));
        assertTrue(channel.finish());
        ByteBuf  readBuf =(ByteBuf)channel.readInbound();

       String readMsg =readBuf.toString(0,readBuf.readableBytes(), Charset.defaultCharset());
        System.out.println(readMsg);

    }
}
