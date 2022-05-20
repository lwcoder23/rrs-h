package com.stu.rrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stu.rrs.dao.RrsCollectDao;
import com.stu.rrs.entity.Collect;
import com.stu.rrs.entity.Comment;
import com.stu.rrs.entity.Restaurant;
import com.stu.rrs.service.RrsCollectService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RrsCollectServiceImpl extends ServiceImpl<RrsCollectDao, Collect> implements RrsCollectService {

    @Resource
    RrsCollectDao collectDao;

    @Override
    public IPage<Collect> getPage(Integer CurrentPage, Integer PageSize, Collect collect) {
        IPage<Collect> page = new Page<>(CurrentPage, PageSize);
        LambdaQueryWrapper<Collect> lqw = new LambdaQueryWrapper<>();

        lqw.eq(Collect::getUid, collect.getUid());
        lqw.like(Strings.isNotEmpty(collect.getRestaurantName()), Collect::getRestaurantName, collect.getRestaurantName());

        return collectDao.selectPage(page, lqw);
    }

}
