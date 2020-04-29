package com.soft1851.springboot.aop.service;

import com.soft1851.springboot.aop.common.Result;
import com.soft1851.springboot.aop.entity.User;

/**
 * @author ZENG
 */
public interface UserService {

    /**
     * 登录
     * @param user
     * @return
     */
    Result login(User user);

    String delete(int userId);
}
