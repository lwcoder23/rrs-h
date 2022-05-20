package com.stu.rrs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu.rrs.entity.Count;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RrsCountDao extends BaseMapper<Count> {
}
