package com.qianliu.ribbon.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.qianliu.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi() throws ExecutionException, InterruptedException {
        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();

        Future<String> f1 = helloService.hiService(1);
        Future<String> f2 = helloService.hiService(2);
        Future<String> f3 = helloService.hiService(3);

        String str = "f1:"+f1.get()+"<br>"+"f2:"+f2.get()+"<br>"+"f3:"+f3.get()+"<br>";

        hystrixRequestContext.close();

        return str;
    }
}
