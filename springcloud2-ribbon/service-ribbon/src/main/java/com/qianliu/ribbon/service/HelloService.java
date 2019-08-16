package com.qianliu.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 调用eureka-client中的服务
     * @return
     */
    public String hiService() {
        return restTemplate.getForObject("http://eureka-client/hi",String.class);
    }

}
