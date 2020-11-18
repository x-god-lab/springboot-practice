package com.example.shirospringboot;

import com.example.shirospringboot.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class ShiroSpringbootApplicationTests {

	@Autowired
	UserServiceImpl service;


	@Test
	void contextLoads() {

		System.out.println(service.queryByName("赵六"));
	}

}
