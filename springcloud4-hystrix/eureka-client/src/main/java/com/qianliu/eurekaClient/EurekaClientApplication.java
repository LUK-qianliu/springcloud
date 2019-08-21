package com.qianliu.eurekaClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
@EnableEurekaClient  //eureka客户端
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class,args);
    }

    // 开启的端口
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hi(@RequestParam int id){
        return "hi，"+"来自于："+port+" "+new Date()+" id:"+id;
    }

    /**
     * 查询所有id
     * @param ids
     * @return
     */
    @RequestMapping("/his")
    public List<String> his(@RequestParam List<Integer> ids){

        List<String> results = new ArrayList<String>();
        for (Integer id: ids) {
            results.add("用户："+id);
            System.out.println(id);
        }
        return results;
    }
}
