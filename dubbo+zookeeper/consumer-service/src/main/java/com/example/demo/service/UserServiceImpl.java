package com.example.demo.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author xin
 * @create 2020-11-24 18:02:51
 */

@Service //放到容器中
@Component
public class UserServiceImpl implements UserService{
    //想拿到provider-server提供的票，去注册中心拿
    @Reference //引用，pom坐标，可以定义路径相同的接口名
    TicketService ticketService;


    @Override
    public void buyTicket() {
        String ticket=ticketService.getTicket();
        System.out.println("在注册中心拿到=>"+ticket);
    }
}
