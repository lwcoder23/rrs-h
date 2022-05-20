package com.stu.rrs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stu.rrs.controller.utils.R;
import com.stu.rrs.entity.Comment;
import com.stu.rrs.service.RrsCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Resource
    RrsCommentService commentService;

    @GetMapping("{CurrentPage}/{PageSize}")
    public R getAllPage(@PathVariable Integer CurrentPage, @PathVariable Integer PageSize, Comment comment) {
        IPage<Comment> Page = commentService.getAllPage(CurrentPage, PageSize, comment);
        if (CurrentPage > Page.getPages()){
            Page = commentService.getAllPage((int)Page.getPages(), PageSize, comment);
        }
        return new R((null != Page), Page);
    }

}
