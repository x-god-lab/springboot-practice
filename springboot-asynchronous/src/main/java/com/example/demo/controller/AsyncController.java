package com.example.demo.controller;

import com.example.demo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xin
 * @create 2020-11-23 15:53:42
 */
@Controller
public class AsyncController {

    @Autowired
    AsyncService service;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        service.hello();
        return "ok";
    }
}
