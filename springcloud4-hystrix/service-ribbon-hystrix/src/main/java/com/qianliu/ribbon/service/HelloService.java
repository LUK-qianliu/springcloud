package com.qianliu.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 调用eureka-client中的服务
     * HystrixCommand默认开启线程隔离
     * @return
     */
    @HystrixCommand(fallbackMethod = "error") // 定义熔断时候返回的方法
    public String hiService() {
        return restTemplate.getForObject("http://eureka-client/hi",String.class);
    }

    /**
     * 熔断的时候调用的真正方法
     * @return
     */
    public String error() {
        return "error!";
    }

}
