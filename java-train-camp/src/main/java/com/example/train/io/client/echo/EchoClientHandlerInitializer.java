package com.example.train.io.client.echo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import lombok.extern.slf4j.Slf4j;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:31 on 2020/11/12
 * @version V0.1
 * @classNmae EchoClientHandlerInitializer
 */
@Slf4j
public class EchoClientHandlerInitializer extends ChannelInitializer {


    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast(  new EchoClientHandler());


    }
}
