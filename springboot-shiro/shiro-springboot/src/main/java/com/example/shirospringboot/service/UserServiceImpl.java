package com.example.shirospringboot.service;

import com.example.shirospringboot.mapper.UserMapper;
import com.example.shirospringboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xin
 * @create 2020-11-18 16:23:34
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper mapper;

    @Override
    public User queryByName(String name) {
        return mapper.queryByName(name);
    }
}
