package com.example.train.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.UnpooledByteBufAllocator;
import org.junit.Test;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:18 on 2020/11/2
 * @version V0.1
 * @classNmae NettyTest
 */
public class NettyTest {

    @Test
    public void byteBufTest(){
        ByteBuf buffer = UnpooledByteBufAllocator.DEFAULT.directBuffer(128,1024);
        System.out.println("buffer capacity="+buffer.capacity());

        byte[] bytes_w =new byte[10];
        for (int i=0;i<bytes_w.length;i++){
            bytes_w[i]=Byte.valueOf((byte)i).byteValue();
        }

        System.out.println("bytes="+bytes_w);
        System.out.println("------------------------------------");
        System.out.println("writerIndex = "+buffer.writerIndex());
        System.out.println("readerIndex = "+buffer.readerIndex());
        buffer.writeBytes(bytes_w);
        System.out.println("------------------------------------");
        System.out.println("writerIndex = "+buffer.writerIndex());
        System.out.println("readerIndex = "+buffer.readerIndex());

        byte[] bytes_r =new byte[5];
        buffer.readBytes(bytes_r);
        System.out.println("------------------------------------");
        System.out.println("writerIndex = "+buffer.writerIndex());
        System.out.println("readerIndex = "+buffer.readerIndex());
        System.out.println("------------------------------------");
        System.out.println("buffer[1] = "+buffer.getByte(1));
        System.out.println("buffer[4] = "+buffer.getByte(4));
        System.out.println("writerIndex = "+buffer.writerIndex());
        System.out.println("readerIndex = "+buffer.readerIndex());


        //超出容量 IndexOutOfBoundsException
        //  System.out.println("buffer[11] = "+buffer.getByte(128));

        System.out.println("------------------------------------");
        System.out.println("buffer memory address before discardReadBytes  = "+buffer.memoryAddress());
        ByteBuf dis_buff = buffer.discardReadBytes();
        System.out.println("buffer discardReadBytes");
        System.out.println("discardReadBytes buffer memory address  = "+dis_buff.memoryAddress());
        System.out.println("writerIndex = "+dis_buff.writerIndex());
        System.out.println("readerIndex = "+dis_buff.readerIndex());
        System.out.println("buffer writerIndex = "+buffer.writerIndex());
        System.out.println("buffer readerIndex = "+buffer.readerIndex());
        System.out.println("buffer[1] = "+buffer.getByte(1));
        System.out.println("buffer[4] = "+buffer.getByte(4));
        System.out.println("buffer capacity = "+buffer.capacity());
        System.out.println("buffer maxCapacity = "+buffer.maxCapacity());
        System.out.println("buffer[4] = "+buffer.getByte(4));
        System.out.println("dis_buff[1] = "+dis_buff.getByte(1));
        System.out.println("dis_buff[4] = "+dis_buff.getByte(4));
        System.out.println("------------------------------------");
        System.out.println("dis_buff writerIndex = "+dis_buff.writerIndex());
        System.out.println("dis_buff readerIndex = "+dis_buff.readerIndex());
        System.out.println(ByteBufUtil.hexDump(bytes_r));
    }
}
