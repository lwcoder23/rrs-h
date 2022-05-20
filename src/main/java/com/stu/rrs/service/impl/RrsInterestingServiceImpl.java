package com.stu.rrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stu.rrs.dao.RrsInterestingDao;
import com.stu.rrs.entity.Interesting;
import com.stu.rrs.entity.User;
import com.stu.rrs.service.RrsInterestingService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (RrsInterestings)表服务实现类
 *
 * @author makejava
 * @since 2022-03-04 10:44:58
 */
@Service("rrsInterestingService")
public class RrsInterestingServiceImpl extends ServiceImpl<RrsInterestingDao, Interesting> implements RrsInterestingService {

    @Resource
    RrsInterestingDao interestingDao;

    @Override
    public IPage<Interesting> getPage(Integer CurrentPage, Integer PageSize, Interesting interesting) {
        IPage<Interesting> page = new Page<>(CurrentPage, PageSize);
        LambdaQueryWrapper<Interesting> lqw = new LambdaQueryWrapper<>();

        lqw.like(Strings.isNotEmpty(interesting.getInteresting()), Interesting::getInteresting, interesting.getInteresting());

        return interestingDao.selectPage(page, lqw);
    }
}
