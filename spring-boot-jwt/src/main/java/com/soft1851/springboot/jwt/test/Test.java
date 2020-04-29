package com.soft1851.springboot.jwt.test;

import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zeng
 * @Date 2020/4/15
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        // 生成token
        Encrypt encrypt = new Encrypt();
        String token = encrypt.getToken(true, "1851", "admin");

        // 打印token
        System.out.println("token: " + token);

        // 解密token
        Decrypt decrypt = new Decrypt();
        DecodedJWT jwt = decrypt.deToken(token);

        System.out.println("issuer: " + jwt.getIssuer());
        System.out.println("isVip:  " + jwt.getClaim("isVip").asBoolean());
        System.out.println("userId: " + jwt.getClaim("userId").asString());
        System.out.println("roleName:     " + jwt.getClaim("roleName").asString());
        System.out.println("过期时间：      " + jwt.getExpiresAt());
        long time = jwt.getExpiresAt().getTime();
        long currentTime = System.currentTimeMillis();
        if (currentTime <= time) {
            System.out.println("token还未失效");
        } else {
            System.out.println("token已过期");
        }

    }
}
