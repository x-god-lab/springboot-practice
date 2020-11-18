package com.example.springsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * @author xin
 * @create 2020-11-16 15:43:36
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //链式编程
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //首页所有人可以访问
        //功能页没有权限无法访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限默认会到登录页面
        http.formLogin()
                .usernameParameter("name")
                .passwordParameter("pwd").loginPage("/toLogin").loginProcessingUrl("/login");

        //开启记住功能
        //默认保存两周
        http.rememberMe().rememberMeParameter("remember");
        //防止网站攻击
        http.csrf().disable();

        //注销功能
        http.logout().logoutSuccessUrl("/toLogin");
    }


    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //这些数据正常从数据库中读
        //密码编码
        //spring security 5.0+使用了许多加密方法
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }

}
