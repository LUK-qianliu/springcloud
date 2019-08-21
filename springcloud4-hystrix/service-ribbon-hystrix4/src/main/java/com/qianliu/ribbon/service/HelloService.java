package com.qianliu.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    // @HystrixCollapser表示请求的时候和并请求，
    // batchMethod = "hisService" 表示请求的方法是hisService
    @HystrixCollapser(batchMethod = "hisService",collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds",value = "300") // 300毫秒内的请求合并为一条
    })
    public Future<String> hiService(Integer id) {
        System.out.println("单个请求。。");
        return null;
    }

    @HystrixCommand
    public List<String> hisService(List<Integer> ids) {
        System.out.println("请求合并。。");
        return restTemplate.getForObject("http://eureka-client/his?ids={1}", List.class, StringUtils.join(ids,","));
    }


}
