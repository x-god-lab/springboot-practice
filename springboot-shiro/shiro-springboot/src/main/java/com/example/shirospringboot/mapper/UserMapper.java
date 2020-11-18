package com.example.shirospringboot.mapper;

import com.example.shirospringboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xin
 * @create 2020-11-18 16:16:19
 */
@Repository
@Mapper
public interface UserMapper {
    User queryByName(String name);
}
