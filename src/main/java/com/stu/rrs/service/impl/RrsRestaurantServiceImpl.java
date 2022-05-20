package com.stu.rrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stu.rrs.dao.RrsRestaurantDao;
import com.stu.rrs.entity.Restaurant;
import com.stu.rrs.service.RrsRestaurantService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (RrsRestaurant)表服务实现类
 *
 * @author makejava
 * @since 2022-03-04 10:44:59
 */
@Service
public class RrsRestaurantServiceImpl extends ServiceImpl<RrsRestaurantDao, Restaurant> implements RrsRestaurantService {

    @Resource
    RrsRestaurantDao restaurantDao;

    @Override
    public IPage<Restaurant> getPage(Integer CurrentPage, Integer PageSize, Restaurant restaurant) {
        IPage<Restaurant> page = new Page<>(CurrentPage, PageSize);
        LambdaQueryWrapper<Restaurant> lqw = new LambdaQueryWrapper<>();

        lqw.like(Strings.isNotEmpty(restaurant.getRestaurantName()), Restaurant::getRestaurantName, restaurant.getRestaurantName());
        lqw.like(Strings.isNotEmpty(restaurant.getInteresting()), Restaurant::getInteresting, restaurant.getInteresting());

        return restaurantDao.selectPage(page, lqw);
    }
}
