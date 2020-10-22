package com.example.train;

import java.nio.ByteBuffer;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:36 on 2020/10/19
 * @version V0.1
 * @classNmae classHelloDirectMemoryOutOfmemory
 */
public class HelloDirectMemoryOutOfMemory {
    private static final int ONE_GB = 1024*1024*1024;
    private static int count= 1;
    public static void main(String[] args) {

        try {
            while (true) {
                ByteBuffer buffer = ByteBuffer.allocateDirect(ONE_GB);
                count++;
            }
        } catch (Exception e) {
            System.out.println("Exception:instance created "+count);
            e.printStackTrace();
        } catch (Error e) {
            System.out.println("Error:instance created "+count);
            e.printStackTrace();
        }

    }


}
