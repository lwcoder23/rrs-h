package com.stu.rrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stu.rrs.entity.Restaurant;

/**
 * (RrsRestaurant)表服务接口
 *
 * @author makejava
 * @since 2022-03-04 10:44:59
 */
public interface RrsRestaurantService extends IService<Restaurant> {

    IPage<Restaurant> getPage(Integer CurrentPage, Integer PageSize, Restaurant restaurant);

}
