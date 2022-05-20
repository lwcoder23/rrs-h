package com.stu.rrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stu.rrs.controller.utils.R;
import com.stu.rrs.dao.RrsUserDao;
import com.stu.rrs.entity.Restaurant;
import com.stu.rrs.entity.User;
import com.stu.rrs.service.RrsUsersService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


/**
 * (RrsUsers)表服务实现类
 *
 * @author
 * @since 2022-03-04 10:44:59
 */
@Service
public class RrsUsersServiceImpl extends ServiceImpl<RrsUserDao, User> implements RrsUsersService {

    @Resource
    RrsUserDao rrsUserDao;

    @Override
    public R verifyLogin(User user) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("user_name", user.getUserName());
        return new R((null != rrsUserDao.selectOne(qw)), rrsUserDao.selectOne(qw));
    }

    @Override
    public IPage<User> getPage(Integer CurrentPage, Integer PageSize, User user) {
        IPage<User> page = new Page<>(CurrentPage, PageSize);
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();

        lqw.like(Strings.isNotEmpty(user.getUserName()), User::getUserName, user.getUserName());
        lqw.like(Strings.isNotEmpty(user.getInteresting()), User::getInteresting, user.getInteresting());
        lqw.like(Strings.isNotEmpty(user.getPhone()), User::getPhone, user.getPhone());
        lqw.like(Strings.isNotEmpty(user.getRole()), User::getRole, user.getRole());

        return rrsUserDao.selectPage(page, lqw);
    }

}
