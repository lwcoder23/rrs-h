package com.stu.rrs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stu.rrs.controller.utils.R;
import com.stu.rrs.entity.Restaurant;
import com.stu.rrs.service.RrsRestaurantService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * (RrsRestaurant)表控制层
 *
 * @author makejava
 * @since 2022-03-04 10:44:59
 */
@CrossOrigin
@RestController
@RequestMapping("/rrsRestaurant")
public class RrsRestaurantController {

    @Resource
    RrsRestaurantService restaurantService;

    @GetMapping("{CurrentPage}/{PageSize}")
    public R getPage(@PathVariable Integer CurrentPage, @PathVariable Integer PageSize, Restaurant restaurant) {
        IPage<Restaurant> Page = restaurantService.getPage(CurrentPage, PageSize, restaurant);
        if (CurrentPage > Page.getPages()){
            Page = restaurantService.getPage((int)Page.getPages(), PageSize, restaurant);
        }
        return new R((null != Page), Page);
    }

    @GetMapping({"{id}"})
    public R getById(@PathVariable Integer id){
        return new R(restaurantService.getById(id));
    }

    @PostMapping
    public R saveRestaurant(@RequestBody Restaurant restaurant) {
        return new R(restaurantService.save(restaurant));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(restaurantService.removeById(id));
    }

    @PutMapping
    public R put(@RequestBody Restaurant restaurant) {
        return new R(true, restaurantService.updateById(restaurant));
    }

}

