package com.qianliu.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ServiceRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class,args);
    }

    /**
     * 使用restTemplate可以规范rest风格的接口,
     * restTemplate提供了一些关于get和post请求的方法
     * @return
     */
    @Bean
    @LoadBalanced  // @LoadBalanced实现负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
