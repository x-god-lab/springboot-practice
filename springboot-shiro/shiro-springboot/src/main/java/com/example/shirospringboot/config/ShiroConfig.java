package com.example.shirospringboot.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xin
 * @create 2020-11-17 17:18:43
 */
@Configuration
public class ShiroConfig {

    //shiroFilterFactoryBean:3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(manager);

        //添加shiro的内置过滤器
        // anon:无需认证就可以访问
        // authc:必须认证了才可以访问
        // user:必须拥有记住我功能才能用
        // perms:拥有某个资源权限才能使用
        // roles:拥有某个角色的权限才能访问
        //拦截
        Map<String,String> map=new LinkedHashMap<>();
        //map.put("/user/add","anon");

        //授权，调到未授权页面
        map.put("/user/add","perms[user:add]");
        map.put("/user/update","perms[user:update]");
        map.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(map);

        bean.setLoginUrl("/toLogin");

        bean.setUnauthorizedUrl("/noMessage");

        return bean;
    }


    //DefaultWebSecurityManager:2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager manager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    //创建UserRealm对象：需要自定义类:1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合shiroDialect : 用来整合 shiro - thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


}
