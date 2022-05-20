package com.stu.rrs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stu.rrs.entity.Comment;

public interface RrsCommentService extends IService<Comment> {

    IPage<Comment> getPage(Integer CurrentPage, Integer PageSize, Comment comment);

    IPage<Comment> getAllPage(Integer CurrentPage, Integer PageSize, Comment comment);

}
