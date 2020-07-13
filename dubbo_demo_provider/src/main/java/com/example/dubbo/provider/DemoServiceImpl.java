package com.example.dubbo.provider;

import com.example.dubbo.api.DemoService;

import java.util.concurrent.CompletableFuture;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello "+ name + " How are you!";
    }

    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        return CompletableFuture.completedFuture(sayHello(name));
    }
}
