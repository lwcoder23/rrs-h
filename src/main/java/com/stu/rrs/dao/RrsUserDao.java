package com.stu.rrs.dao;

import com.stu.rrs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * (RrsUsers)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-04 10:44:59
 */
@Mapper
public interface RrsUserDao extends BaseMapper<User> {
}

