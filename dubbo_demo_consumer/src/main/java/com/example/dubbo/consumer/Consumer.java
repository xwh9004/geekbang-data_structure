package com.example.dubbo.consumer;

import com.example.dubbo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;

/**
 * <p><b>Description:</b>
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:41 on 2020/3/25
 * @version V0.1
 * @classNmae com.example.dubbo.consumer.Consumer
 */
public class Consumer {



        public static void main(String[] args) throws Exception {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
            context.start();
            DemoService demoService = context.getBean("demoService", DemoService.class);
            CompletableFuture<String> hello = demoService.sayHelloAsync("Jesse");

            System.out.println("result: " + hello.get());
        }

}
