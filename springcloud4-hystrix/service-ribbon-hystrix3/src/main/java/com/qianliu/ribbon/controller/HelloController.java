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

    @GetMapping(value = "/hii")
    public String hii() {
        //开启缓存必须在hystrix上下文中
        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();

        // 在同一个hystrix上下文中，因为缓存的key被设置为固定值，所以下面两行取出来的数据相等
        String cache = helloService.cache(restTemplate,1);
        String cache2 = helloService.cache(restTemplate,2);

        hystrixRequestContext.close();
        return "cache:"+cache+"<br>cache2:"+cache2;
    }
}
