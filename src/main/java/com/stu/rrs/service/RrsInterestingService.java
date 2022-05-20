package com.stu.rrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stu.rrs.entity.Interesting;
import com.stu.rrs.entity.User;

/**
 * (RrsInterestings)表服务接口
 *
 * @author makejava
 * @since 2022-03-04 10:44:58
 */
public interface RrsInterestingService extends IService<Interesting> {

    IPage<Interesting> getPage(Integer CurrentPage, Integer PageSize, Interesting interesting);

}
