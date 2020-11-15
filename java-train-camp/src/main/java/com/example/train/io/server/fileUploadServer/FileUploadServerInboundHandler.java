package com.example.train.io.server.fileUploadServer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

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
public class FileUploadServerInboundHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf fileBuffer;

    private int count = 0;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        fileBuffer =  Unpooled.buffer();
        log.info("Server channelActive: " );
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.info("Server channelInactive! " );
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
         ByteBuf in = (ByteBuf) msg;
        log.info("Server received byte size = : " + in.readableBytes());
        count =count+in.readableBytes();
        log.info("Server received byte total count = : " + count);
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
        log.info("Server channelReadComplete! " );

        File file = new File(UUID.randomUUID().toString());
        if(!file.exists()){
            file.createNewFile();
        }
        try (FileOutputStream fou =  new FileOutputStream(file);){
            fou.write(fileBuffer.array());
            fou.flush();
        }

        ByteBuf out = Unpooled.buffer();
        out.writeBytes("Server received completed!".getBytes());
        ctx.writeAndFlush(out).addListener(ChannelFutureListener.CLOSE);


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
