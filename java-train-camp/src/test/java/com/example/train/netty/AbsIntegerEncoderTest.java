package com.example.train.netty;

import com.example.train.week2.server.echo.AbsIntegerEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:53 on 2020/11/5
 * @version V0.1
 * @classNmae AbsIntegerEncoderTest
 */
public class AbsIntegerEncoderTest {

    @Test
    public void testEncoded() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 1; i < 10; i++) {
            buf.writeInt(i * (-1));
        }
        EmbeddedChannel channel = new EmbeddedChannel(
                new AbsIntegerEncoder());
        assertTrue(channel.writeOutbound(buf));
        assertTrue(channel.finish());
      // read bytes
        for (int i = 1; i < 10; i++) {
            assertEquals((Integer)i, channel.readOutbound());
        }
        assertNull(channel.readOutbound());
    }
}
