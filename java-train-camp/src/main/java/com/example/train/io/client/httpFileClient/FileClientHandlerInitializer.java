package com.example.train.io.client.httpFileClient;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.HttpClientCodec;
import lombok.extern.slf4j.Slf4j;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:31 on 2020/11/12
 * @version V0.1
 * @classNmae FileClientHandlerInitializer
 */
@Slf4j
public class FileClientHandlerInitializer extends ChannelInitializer {


    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new HttpClientCodec())
                .addLast(new FileClientHandler());


    }
}
