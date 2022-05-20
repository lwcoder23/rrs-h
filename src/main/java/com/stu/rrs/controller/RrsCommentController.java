package com.stu.rrs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stu.rrs.controller.utils.R;
import com.stu.rrs.entity.Comment;
import com.stu.rrs.entity.Restaurant;
import com.stu.rrs.service.RrsCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RrsComment)表控制层
 *
 * @author makejava
 * @since 2022-03-04 10:44:58
 */
@RestController
@CrossOrigin
@RequestMapping("/rrsComment")
public class RrsCommentController {
    @Resource
    RrsCommentService commentService;

    @GetMapping("{CurrentPage}/{PageSize}")
    public R getPage(@PathVariable Integer CurrentPage, @PathVariable Integer PageSize, Comment comment) {
        IPage<Comment> Page = commentService.getPage(CurrentPage, PageSize, comment);
        if (CurrentPage > Page.getPages()){
            Page = commentService.getPage((int)Page.getPages(), PageSize, comment);
        }
        return new R((null != Page), Page);
    }

    @PostMapping
    public R saveComment(@RequestBody Comment comment) {
        return new R(commentService.save(comment));
    }

    @DeleteMapping("{id}")
    public R deleteComment(@PathVariable Integer id){
        return new R(commentService.removeById(id));
    }

}

