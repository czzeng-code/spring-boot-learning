package com.soft1851.springboot.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author Zeng
 * @ClassName JwtTokenUtil
 * @Description TOOD
 * @Date 2020/4/15
 * @Version 1.0
 **/
@Slf4j
public class JwtTokenUtil {
     static String secret = SaltUtil.md5Hex("mySecret");


    /**
     * 加密
     *
     * @param userId
     * @param userRole
     * @param expiresAt
     * @return String
     */
    public static String getToken(final String userId, final String userRole, Date expiresAt) {
        String token = null;
        assert secret != null;
        token = JWT.create()
                .withIssuer("auth0")
                .withClaim("userId", userId)
                .withClaim("userRole", userRole)
                .withExpiresAt(expiresAt)
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    /**
     * 解密
     *
     * @param token
     * @return DecodedJWT
     */
    public static DecodedJWT deToken(final String token) {
        DecodedJWT jwt;
        JWTVerifier verifier = null;
        verifier = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("auth0")
                .build();
        assert verifier != null;
        jwt = verifier.verify(token);
        return jwt;
    }

    /**
     * 获取userId
     * @param token
     * @return String
     */
    public static String getUserId(String token) {
        return deToken(token).getClaim("userId").asString();
    }

    /**
     * 获取role
     * @param token
     * @return String
     */
    public static String getUserRole(String token) {
        return deToken(token).getClaim("userRole").asString();
    }

    /**
     * 验证是否过期
     *
     * @param token
     * @return boolean
     */
    public static boolean isExpiration(String token) {
        return deToken(token).getExpiresAt().before(new Date());
    }
}
