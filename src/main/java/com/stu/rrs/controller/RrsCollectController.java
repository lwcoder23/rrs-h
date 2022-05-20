package com.stu.rrs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stu.rrs.controller.utils.R;
import com.stu.rrs.entity.Collect;
import com.stu.rrs.entity.Comment;
import com.stu.rrs.service.RrsCollectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Collect)表控制层
 *
 * @author makejava
 * @since 2022-03-04 10:44:58
 */
@RestController
@CrossOrigin
@RequestMapping("/rrsCollect")
public class RrsCollectController {

    @Resource
    RrsCollectService collectService;

    @GetMapping("{CurrentPage}/{PageSize}")
    public R getPage(@PathVariable Integer CurrentPage, @PathVariable Integer PageSize, Collect collect) {
        IPage<Collect> Page = collectService.getPage(CurrentPage, PageSize, collect);
        if (CurrentPage > Page.getPages()){
            Page = collectService.getPage((int)Page.getPages(), PageSize, collect);
        }
        return new R((null != Page), Page);
    }

    @PostMapping
    public R saveCollect(@RequestBody Collect collect) {
        return new R(collectService.save(collect));
    }

    @DeleteMapping("{id}")
    public R deleteCollect(@PathVariable Integer id) {
        return new R(collectService.removeById(id));
    }

}

