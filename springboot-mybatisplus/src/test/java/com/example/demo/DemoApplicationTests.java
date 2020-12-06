package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserMapper mapper;

    @Test
    void contextLoads() {
        List<User> list=mapper.selectList(null);
        list.forEach(System.out::println);
    }

    //实现插入
    @Test
    void insert(){
        User user=new User();
        //user.setId(8);
        user.setName("test2");
        user.setAge(3543);
        user.setEmail("12321356165@qq.com");
        int result=mapper.insert(user);
        System.out.println(result);
    }

    @Test
    void update(){
        User user=new User();
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.eq("id","4");
        //user.setId(8);
        user.setName("test2");
        int result=mapper.update(user,userQueryWrapper);
        System.out.println(result);
    }

    //测试乐观锁成功
    @Test
    void testOptimisticLocker(){
        User user=mapper.selectById(1);
        user.setName("test3");
        user.setEmail("7897486489@qq.com");
        mapper.updateById(user);
    }

    //测试乐观锁失败 多线程
    @Test
    void testOptimisticLocker2(){
        User user=mapper.selectById(2);
        user.setName("test3");
        user.setEmail("7897486489@qq.com");

        //模拟另一个线程执行了插队操作
        User user2=mapper.selectById(2);
        user2.setName("test33");
        user2.setEmail("7897486489@qq.com");
        mapper.updateById(user2);
        mapper.updateById(user);  //如果没有乐观锁将会覆盖插队线程的值
    }


    //测试查询
    @Test
    void testSelectById(){
        User user=mapper.selectById(5);
        System.out.println(user);
        
    }

    //测试批量查询
    @Test
    void testSelectByBatchId(){
        List<User> user=mapper.selectBatchIds(Arrays.asList(1,2,3));
        user.forEach(System.out::println);

    }

    //测试条件查询之一map操作
    @Test
    void testSelectByBatchIds(){
        HashMap<String,Object> map=new HashMap<>();
        //自定义查询
        map.put("name","test2");
        map.put("id",4);
       // map.put("email","12321356165@qq.com");
        List<User> users=mapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //测试分页查询
    @Test
    void testPage(){
        Page<User> page = new Page<>(2,5);
        mapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    //测试删除
    @Test
    void testDeleteById(){
        mapper.deleteById(1);
    }

    //批量删除
    @Test
    void testDeleteByBatchId(){
        mapper.deleteBatchIds(Arrays.asList(7,9,4));
    }

    //通过map删除
    @Test
    void testDeleteMap(){
        HashMap<String,Object> map=new HashMap<>();
        map.put("name","test2");
        mapper.deleteByMap(map);
    }

    //

}
