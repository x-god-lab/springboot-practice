package com.example.shirospringboot.config;

import com.example.shirospringboot.pojo.User;
import com.example.shirospringboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xin
 * @create 2020-11-17 17:20:40
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService service;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        //拿到当前用户的对象
        Subject subject= SecurityUtils.getSubject();
        User currentUser=(User) subject.getPrincipal();
        info.addStringPermission(currentUser.getPerms());

        System.out.println("执行了=>授权doGetAuthorizationInfo");
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthorizationInfo");
        // 用户名，密码，数据库取
        //service.queryByName();

        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;

        User user=service.queryByName(token.getUsername());

        if (user==null){
            return null; //UnExceptionAccount
        }

        Subject currentSubject=SecurityUtils.getSubject();
        Session session=currentSubject.getSession();
        session.setAttribute("loginUser",user);

        //密码认证。shiro做
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
