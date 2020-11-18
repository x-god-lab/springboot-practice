package com.example.shirospringboot.service;

import com.example.shirospringboot.mapper.UserMapper;
import com.example.shirospringboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xin
 * @create 2020-11-18 16:20:52
 */
public interface   UserService {
    public User queryByName(String name);
}
