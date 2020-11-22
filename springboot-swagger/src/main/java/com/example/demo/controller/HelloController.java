package com.example.demo.controller;

import com.example.demo.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xin
 * @create 2020-11-19 17:10:46
 */
@Controller
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @PostMapping("/user")
    @ResponseBody
    public User user(){
        return new User();
    }

    @ApiOperation("哈喽")
    @RequestMapping("/hello2")
    @ResponseBody
    public String hello2(String name){
        return "hello"+name;
    }
}
