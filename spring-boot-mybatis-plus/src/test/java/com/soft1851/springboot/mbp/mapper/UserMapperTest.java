package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void selectAll() {

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void insert() {
        User user = User.builder()
                .nickname("测试")
                .password("000")
                .createTime(LocalDateTime.now())
                .build();
        int row = userMapper.insert(user);
        assertEquals(1, row);
    }

    @Test
    void delete() {
        int i = userMapper.deleteById(41);
        assertEquals(1, i);
    }

    @Test
    void update() {
//        userMapper.update()
        User user = User.builder()
                .id(41L)
                .nickname("测试修改")
                .password("000x")
                .createTime(LocalDateTime.now())
                .build();
        int i = userMapper.updateById(user);
    }
}