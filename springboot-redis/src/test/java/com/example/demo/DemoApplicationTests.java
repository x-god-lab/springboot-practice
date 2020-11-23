package com.example.demo;

import com.example.demo.pojo.User;
import com.example.demo.utils.RedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {

        //企业开发中80%不会使用原生的方法编写代码
        //RedisUtils 工具类

        //redisTemplate  操作不同的数据类型
        //opsForList 操作List,类似于List
        //opsForValue 操作字符串，类似于String
        //opsForGeo()
        //opsForHash()
        //opsForHyperLogLog()
        //opsForSet()
        //除了基本的操作，我们常用的方法都能通过redisTemplate操作，比如事务和CRUD

        //获取Redis的连接对象
//        RedisConnection connection=redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

        redisTemplate.opsForValue().set("xin","测试");
        System.out.println(redisTemplate.opsForValue().get("xin"));
    }


    @Test
    public void test() throws JsonProcessingException {
        //真实的开发一般都是传递json数据
        User user=new User("xin",9);
        //String jsonUser=new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
