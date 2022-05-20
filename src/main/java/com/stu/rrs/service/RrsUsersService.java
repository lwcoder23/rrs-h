package com.stu.rrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stu.rrs.controller.utils.R;
import com.stu.rrs.entity.Restaurant;
import com.stu.rrs.entity.User;

/**
 * (RrsUsers)表服务接口
 *
 * @author makejava
 * @since 2022-03-04 10:44:59
 */
public interface RrsUsersService extends IService<User> {

    R verifyLogin(User user);

    IPage<User> getPage(Integer CurrentPage, Integer PageSize, User user);

}
