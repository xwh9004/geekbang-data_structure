package com.example.train.io.client.fileClient;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.*;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:27 on 2020/11/4
 * @version V0.1
 * @classNmae FileClientHandler
 */
@Slf4j
public class FileClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {


        // Prepare the HTTP request
        HttpRequest fullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST,"/");

        HttpDataFactory dataFactory = new DefaultHttpDataFactory(DefaultHttpDataFactory.MINSIZE);


        DiskFileUpload.deleteOnExitTemporaryFile = true; // should delete file on exit (in normal exit)
        DiskFileUpload.baseDirectory = null; // system temp directory
        DiskAttribute.deleteOnExitTemporaryFile = true; // should delete file on exit (in normal exit)
        DiskAttribute.baseDirectory = null; // system temp directory
        //multipart true 多文件传输
        HttpPostRequestEncoder bodyRequestEncoder
                =new HttpPostRequestEncoder(dataFactory, fullHttpRequest, false); // true => multipart
       //prepare httpHeader
        HttpHeaders headers = fullHttpRequest.headers();
//        headers.set(HttpHeaderNames.HOST, host);
        headers.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
        headers.set(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP + "," + HttpHeaderValues.DEFLATE);

        headers.set(HttpHeaderNames.ACCEPT_CHARSET, "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
        headers.set(HttpHeaderNames.ACCEPT_LANGUAGE, "fr");
//        headers.set(HttpHeaderNames.REFERER, uriSimple.toString());
//        headers.set(HttpHeaderNames.USER_AGENT, "Netty Simple Http Client side");
        headers.set(HttpHeaderNames.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");

        bodyRequestEncoder.addBodyAttribute("getform", "POST");
        bodyRequestEncoder.addBodyAttribute("info", "first value");

        File file =null;
        bodyRequestEncoder.addBodyFileUpload("myfile", file, "application/x-zip-compressed", false);

       // finalize request
        fullHttpRequest = bodyRequestEncoder.finalizeRequest();
        ctx.writeAndFlush(fullHttpRequest);
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        log.info("FileClient channelRead0");

        System.out.println(
                "FileClient received: " + in.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.error("FileClient userEventTriggered...");
        super.userEventTriggered(ctx, evt);
    }
}
