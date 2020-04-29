package com.soft1851.springboot.jwt.interceptor;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.soft1851.springboot.jwt.common.ResultCode;
import com.soft1851.springboot.jwt.exception.JwtException;
import com.soft1851.springboot.jwt.service.AdminService;
import com.soft1851.springboot.jwt.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Zeng
 * @ClassName JwtInterceptor
 * @Description Jwt拦截器
 * @Date 2020/4/15
 * @Version 1.0
 **/
@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Resource
    private AdminService adminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            log.info("### 用户未登录，请先登录 ###");
            throw new JwtException("用户未登录，请先登录", ResultCode.USER_NOT_SIGN_IN);
        } else {
            log.info("## token= {}", token);
            if (!adminService.checkRole(JwtTokenUtil.getUserRole(token))) {
                log.info("### 用户权限不足 ###");
                throw new JwtException("用户权限不足", ResultCode.USER_NO_AUTH);
            } else {
                return true;
            }
        }
    }
}
