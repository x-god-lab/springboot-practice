package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


/**
 * @author xin
 * @create 2020-11-19 17:14:44
 */
@Configuration
@EnableSwagger2 //开启Swagger
public class SwaggerConfig {


    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("C");
    }

    //配置了Swagger的bean实例
    @Bean
    public Docket docket(Environment environment){
        Profiles profiles=Profiles.of("dev","test");

        boolean flag=environment.acceptsProfiles(profiles);
        //enable是否启动swagger,false不能启动swagger
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //配置API分组
                .groupName("xin")
                //.enable(flag)
                .select()
                //RequestHandlerSelectors,配置要扫描的接口
                //basePackage,指定要扫描的包
                //any(),扫描全部
                //none()，都不扫描
                //withClassAnnotation:扫描类上的注解，参数是一个反射对象
                //withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                    //path()：过滤什么路径
                //.paths(PathSelectors.ant("/xin/**"))
                .build();
    }


    private ApiInfo apiInfo(){
         Contact contact = new Contact("xin", "https://github.com/x-god-lab", "175066@qq.com");

        return new ApiInfo("测试日记",
                "Swagger来玩玩",
                "1.0", "urn:tos",
                contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}
