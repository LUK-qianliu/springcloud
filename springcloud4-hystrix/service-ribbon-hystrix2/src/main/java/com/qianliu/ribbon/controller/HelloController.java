package com.qianliu.ribbon.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.qianliu.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/hi")
    public String hi() throws ExecutionException, InterruptedException {
        return helloService.testPool();
    }

}
