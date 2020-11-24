package com.example.demo.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author xin
 * @create 2020-11-24 16:31:07
 */

//服务注册与发现
@Service
@Component
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "测试一次";
    }
}
