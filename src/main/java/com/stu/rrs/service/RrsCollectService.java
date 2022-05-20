package com.stu.rrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stu.rrs.entity.Collect;
import com.stu.rrs.entity.Comment;

public interface RrsCollectService extends IService<Collect> {
    IPage<Collect> getPage(Integer CurrentPage, Integer PageSize, Collect collect);
}
