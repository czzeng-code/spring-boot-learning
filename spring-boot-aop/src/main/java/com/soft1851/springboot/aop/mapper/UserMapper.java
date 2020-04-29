package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ZENG
 */
public interface UserMapper {

    /**
     * 查询
     * @param user
     * @return
     */
    @Select("SELECT * FROM t_user WHERE username=#{username} AND password=#{password}")
    User select(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("DELETE FROM t_user WHERE id={userId}")
    int delete(int userId);
}
