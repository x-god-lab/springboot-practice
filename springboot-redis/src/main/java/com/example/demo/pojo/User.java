package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author xin
 * @create 2020-11-23 18:25:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
//在企业中，所有的pojo都会序列化
public class User implements Serializable{

    private String username;
    private int age;

}
