package com.qianliu.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy   // 开启zuul网关
@EnableEurekaClient
public class ServiceZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run( ServiceZuulApplication.class, args );
    }
}
