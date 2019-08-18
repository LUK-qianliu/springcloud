package com.qianliu.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.qianliu.ribbon.service.pool.ACommand;
import com.qianliu.ribbon.service.pool.BCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class HelloService {

    // 测试依赖隔离
    public String testPool() throws ExecutionException, InterruptedException {
        ACommand aCommand = new ACommand();
        BCommand bCommand1 = new BCommand();
        BCommand bCommand2 = new BCommand();

        // 同步调用
        String val1 = aCommand.execute();
        String val2 = bCommand1.execute();
        String val3 = bCommand2.execute();

        // 异步调用
//        Future<String> f1 = aCommand.queue();
//        Future<String> f2 = bCommand1.queue();
//        Future<String> f3 = bCommand2.queue();

        return "val1=" + val1 +"<br>"+ "val2=" + val2 +"<br>"+ "val3=" + val3;
        //return "f1=" + f1.get() +"<br>"+ "f2=" + f2.get() +"<br>"+ "f3=" + f3.get();
    }

}
