package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mq_xu
 * @since 2020-04-16
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     *
     * @param userId
     * @return
     */
    List<Map<String, Object>> getUserById(String userId);
}
