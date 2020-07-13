package com.example.dubbo.provider;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:45 on 2020/3/25
 * @version V0.1
 * @classNmae Provider
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        System.out.println("Provider started");
        System.in.read();
    }

}
