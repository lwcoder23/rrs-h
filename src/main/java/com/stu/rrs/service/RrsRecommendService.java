package com.stu.rrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stu.rrs.entity.Recommend;
import com.stu.rrs.entity.Restaurant;

public interface RrsRecommendService extends IService<Recommend> {
    IPage<Recommend> getPage(Integer CurrentPage, Integer PageSize, Recommend recommend);
}
