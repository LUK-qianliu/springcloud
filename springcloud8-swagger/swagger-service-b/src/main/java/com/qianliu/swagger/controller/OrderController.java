package com.qianliu.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Api("订单接口")
@RestController
public class OrderController {

    private HashMap<String,String> hashMap = new HashMap();

    public OrderController(){
        hashMap.put("1","订单1");
        hashMap.put("2","订单2");
        hashMap.put("3","订单3");
    }

    @ApiOperation(value = "查找订单信息",notes = "通过id查找") //方法描述
    @ApiImplicitParam(name = "id",dataType = "String",value = "订单信息",required = true)// id参数
    @RequestMapping(value = "/getOrder",method = RequestMethod.GET)
    public String getOrder(String id){
        return hashMap.get(id);
    }
}
