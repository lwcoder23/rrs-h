package com.stu.rrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stu.rrs.dao.RrsRecommendDao;
import com.stu.rrs.entity.Recommend;
import com.stu.rrs.entity.Restaurant;
import com.stu.rrs.service.RrsRecommendService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RrsRecommendServiceImpl extends ServiceImpl<RrsRecommendDao, Recommend> implements RrsRecommendService {

    @Resource
    RrsRecommendDao recommendDao;

    @Override
    public IPage<Recommend> getPage(Integer CurrentPage, Integer PageSize, Recommend recommend) {
        IPage<Recommend> page = new Page<>(CurrentPage, PageSize);
        LambdaQueryWrapper<Recommend> lqw = new LambdaQueryWrapper<>();
        return recommendDao.selectPage(page, lqw);
    }
}
