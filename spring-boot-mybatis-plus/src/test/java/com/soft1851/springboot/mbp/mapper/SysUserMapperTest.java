package com.soft1851.springboot.mbp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysUserMapperTest {
    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    void getUserById() {
        sysUserMapper.getUserById("2").forEach(System.out::println);
    }
}