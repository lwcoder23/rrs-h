package com.stu.rrs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu.rrs.entity.Restaurant;
import org.apache.ibatis.annotations.Mapper;

/**
 * (RrsRestaurant)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-04 10:44:59
 */
@Mapper
public interface RrsRestaurantDao extends BaseMapper<Restaurant> {
}

