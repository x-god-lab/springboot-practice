package com.example.demo.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author xin
 * @create 2020-11-24 16:33:13
 */

public interface UserService {
    void buyTicket();
}
