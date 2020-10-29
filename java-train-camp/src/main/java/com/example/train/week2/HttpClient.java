package com.example.train.week2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:18 on 2020/10/29
 * @version V0.1
 * @classNmae HttpClient
 */
@Slf4j
public class HttpClient {

    public static void main(String[] args) {
        Channel channel = null;
        ChannelFuture channelFuture = channel.connect(new InetSocketAddress("127.0.0.1", 8808));
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                log.info("operationComplete get Future...");
                if (channelFuture.isSuccess()){
                    ByteBuf buffer = Unpooled.copiedBuffer(
                            "Hello", Charset.defaultCharset());
                    ChannelFuture wf = channelFuture.channel()
                            .writeAndFlush(buffer);
                } else {
                    Throwable cause = channelFuture.cause();
                    cause.printStackTrace();
                }
            }
        });
    }
}
