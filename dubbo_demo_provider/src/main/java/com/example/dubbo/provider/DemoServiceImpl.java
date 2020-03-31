package com.example.dubbo.provider;

import com.example.dubbo.api.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello "+ name + " How are you!";
    }
}
