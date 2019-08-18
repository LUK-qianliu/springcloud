package com.qianliu.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    /**
     * 表示开启缓存，并且判断缓存的id的方法就是getCacheKey
     * getCacheKey的放回值相同，表示需要查询的数据在缓存中可以直接拿
     * @param restTemplate
     * @param id
     * @return
     */
    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand
    public String cache( RestTemplate restTemplate,int id) {
        String forObject = restTemplate.getForObject("http://eureka-client/hi?id="+id, String.class);
        return forObject;
    }

    //key设置为常量，表示无需判断key是否相等(也就是无需判断id是否相等)，所有的数据都从缓存中拿去
    // 当hystrix判断key相等就会从缓存中拿数据
    // getCacheKey(RestTemplate restTemplate)内的参数必须和cache( RestTemplate restTemplate) 相同
    public String getCacheKey(RestTemplate restTemplate,int id) {
        return "hello";
    }

}
