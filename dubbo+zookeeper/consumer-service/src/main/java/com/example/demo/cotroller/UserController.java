package com.example.demo.cotroller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xin
 * @create 2020-11-24 17:50:35
 */
@Controller
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("/test")
    public void test(){
        service.buyTicket();
    }
}
