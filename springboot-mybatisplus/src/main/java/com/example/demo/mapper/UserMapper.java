package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author xin
 * @create 2020-12-05 00:48:15
 */
@Repository //代表持久层
public interface UserMapper extends BaseMapper<User> {
}
