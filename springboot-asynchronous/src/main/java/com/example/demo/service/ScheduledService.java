package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author xin
 * @create 2020-11-23 16:54:39
 */
@Service
public class ScheduledService {


    /**
     * 0 2 17 * * ? 每天的17点2分00秒执行一次
     * 0 0/5 17,19 * * ? 每天的17点到19点每五分钟执行一次
     * 0 2 17 ？ * 1-6 每个月的周一到周六的17点2分执行一次
     */
    //cron 表达式
    //秒 分 时 日 月 周几~
    @Scheduled(cron = "0/2 10,11 17 * * Mon")
    public void hello(){
        System.out.println("hello,你被执行...");
    }
}
