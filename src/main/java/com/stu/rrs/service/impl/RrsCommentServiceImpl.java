package com.stu.rrs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stu.rrs.dao.RrsCommentDao;
import com.stu.rrs.entity.Comment;
import com.stu.rrs.service.RrsCommentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RrsCommentServiceImpl extends ServiceImpl<RrsCommentDao, Comment> implements RrsCommentService {

    @Resource
    RrsCommentDao commentDao;

    @Override
    public IPage<Comment> getPage(Integer CurrentPage, Integer PageSize, Comment comment) {
        IPage<Comment> page = new Page<>(CurrentPage, PageSize);
        LambdaQueryWrapper<Comment> lqw = new LambdaQueryWrapper<>();

        lqw.eq(Comment::getRid, comment.getRid());

        return commentDao.selectPage(page, lqw);
    }

    @Override
    public IPage<Comment> getAllPage(Integer CurrentPage, Integer PageSize, Comment comment) {
        IPage<Comment> page = new Page<>(CurrentPage, PageSize);
        LambdaQueryWrapper<Comment> lqw = new LambdaQueryWrapper<>();

        lqw.like(Strings.isNotEmpty(comment.getUserName()), Comment::getUserName, comment.getUserName());
        lqw.like(Strings.isNotEmpty(comment.getRestaurantName()), Comment::getRestaurantName, comment.getRestaurantName());

        return commentDao.selectPage(page, lqw);
    }
}
