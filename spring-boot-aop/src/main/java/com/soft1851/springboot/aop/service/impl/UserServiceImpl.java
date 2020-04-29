package com.soft1851.springboot.aop.service.impl;

import com.soft1851.springboot.aop.common.Result;
import com.soft1851.springboot.aop.common.ResultCode;
import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.mapper.UserMapper;
import com.soft1851.springboot.aop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * @author Zeng
 * @ClassName UserServiceImpl
 * @Description TOOD
 * @Date 2020/4/13
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(User user) {
        User user1 = userMapper.select(user);
        assert user1 != null;
        log.info("登录成功");
        return Result.success();
    }

    @Override
    public String delete(int userId) {
        int row = userMapper.delete(userId);
        assert row>=1;
        return ResultCode.DELETE_SUCCESS.message();
    }
}
