package com.stu.rrs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu.rrs.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * (RrsComment)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-04 10:44:58
 */
@Mapper
public interface RrsCommentDao extends BaseMapper<Comment> {
}

