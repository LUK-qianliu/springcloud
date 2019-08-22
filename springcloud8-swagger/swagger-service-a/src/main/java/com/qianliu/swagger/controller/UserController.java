package com.qianliu.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Api("用户接口")
@RestController
public class UserController {

    private HashMap<String,String> hashMap = new HashMap();

    public UserController(){
        hashMap.put("1","用户1");
        hashMap.put("2","用户2");
        hashMap.put("3","用户3");
    }

    @ApiOperation(value = "查找用户信息",notes = "通过id查找") //方法描述
    @ApiImplicitParam(name = "id",dataType = "String",value = "用户信息",required = true)// id参数
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public String getUser(String id){
        return hashMap.get(id);
    }
}
