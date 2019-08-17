package com.qianliu.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.print.DocFlavor;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //开启feign
public class ServiceFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class,args);
    }
}
