package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.common.Result;
import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Zeng
 * @ClassName UserLoginController
 * @Description TOOD
 * @Date 2020/4/13
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping(value = "/api/user")
public class UserLoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return  userService.login(user);
    }

    @DeleteMapping("/delete")
    @AuthToken(role_name = "admin")
    public String delete(@RequestParam int userId) {
        return userService.delete(userId);
    }
}
