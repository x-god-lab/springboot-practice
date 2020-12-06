package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xin
 * @create 2020-12-06 22:11:12
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    UserMapper mapper;

    @Test
    void contextLoads(){
        //查询name不为空的方法，并且邮箱不为空的用户，年龄大于21
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age",21);
        mapper.selectList(wrapper).forEach(System.out::println);

    }

    @Test
    void test2(){
        //查询name=Billie的人
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("name","Billie");
        mapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test3(){
        //查询年龄在20岁30岁之间的用户
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.between("age",20,30);
        System.out.println(mapper.selectCount(wrapper));
    }

    @Test
    void test4(){
        //模糊查询
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.notLike("name","i")
                .likeLeft("name",33);
        mapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test5(){
        //模糊查询
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        //id在子查询中查出来的
        wrapper.inSql("id","select id from user id>3");
        mapper.selectList(wrapper).forEach(System.out::println);
    }


    @Test
    void test6(){
        //模糊查询
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        //通过id进行排序
        wrapper.orderByAsc("id");
        mapper.selectList(wrapper).forEach(System.out::println);
    }
}
