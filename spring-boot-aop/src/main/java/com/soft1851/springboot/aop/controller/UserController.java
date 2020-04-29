package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zeng
 * @ClassName UserController
 * @Description TOOD
 * @Date 2020/4/13
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping(value = "/api/")
public class UserController {
    /**
     * 无需任何校验。无需加注解
     * @param name
     * @return String
     */
    @GetMapping("hello")
    public String hello(String name){
        log.info("hello()方法无需鉴权，也无需认证，当前用户名" + name);
        return "hello方法访问成功";
    }

    /**
     * 需要认证，此时该方法需要加注解，但是不需要传角色
     * @param name
     * @return String
     */
    @GetMapping("user")
    @AuthToken
    public String user(String name){
        log.info("user()方法需认证，当前用户名" + name);
        return "user()方法访问成功";
    }

    /**
     * 需要鉴权，此时该方法需要加注解，需要传角色
     * 角色可以传多个
     * 如果需要更负责的逻辑操作，建议使用Spring Security Apach Shiro等安全框架
     * @param name
     * @return String
     */
    @GetMapping("admin")
    @AuthToken(role_name = {"admin","Admin"})
    public String admin(String name){
        log.info("admin()方法需要鉴权,当前用户名" + name);
        return "admin()方法访问成功";
    }
}
