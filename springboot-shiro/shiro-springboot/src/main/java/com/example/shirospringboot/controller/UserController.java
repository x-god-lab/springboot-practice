package com.example.shirospringboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xin
 * @create 2020-11-17 16:34:04
 */
@Controller
public class UserController {

    @RequestMapping({"/", "/index"})
    public String index(Model model){
        model.addAttribute("msg","Hello Controller");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }
    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        //获取当前的用户
        Subject subject =SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            subject.login(token);//执行登录的方法，如果没有异常就显示OK了
            return "index";
        }catch (UnknownAccountException uae){//用户名不对
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException ice){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }


    @RequestMapping("/noMessage")
    @ResponseBody
    public String NoMessage(){
        return "未经授权无法访问此页面";
    }
}
