package com.soft1851.springboot.mbp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Zeng
 * @ClassName User
 * @Description TOOD
 * @Date 2020/4/16
 * @Version 1.0
 **/
@Data
@Builder
public class User {
    @TableId(value = "id",type = IdType.INPUT)
    private Long id;
    private String mobile;
    private String password;
    private String nickname;
    private String avatar;
    private String gender;
    private LocalDate birthday;
    private String address;
    private String introduction;
    private String email;
    private String homepage;
    private Short follows;
    private Short fans;
    private Short articles;
    private LocalDateTime createTime;
    private Short status;
}