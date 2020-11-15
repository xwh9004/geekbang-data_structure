package com.example.train.io.server.httpFileServer;

import com.example.train.io.server.echo.HeartbeatHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.extern.slf4j.Slf4j;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:49 on 2020/11/12
 * @version V0.1
 * @classNmae EchoServerChannelInitializer
 */
@Slf4j
public class FileServerChannelInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline
                .addLast(new HttpServerCodec())  //add Http Request&Response Handler
                .addLast(new FileServerInboundHandler())
                .addLast(new HeartbeatHandler());
    }
}
