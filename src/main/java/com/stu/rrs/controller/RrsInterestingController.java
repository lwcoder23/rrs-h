package com.stu.rrs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stu.rrs.controller.utils.R;
import com.stu.rrs.entity.Interesting;
import com.stu.rrs.entity.User;
import com.stu.rrs.service.RrsInterestingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RrsInterestings)表控制层
 *
 * @author makejava
 * @since 2022-03-04 10:44:58
 */
@RestController
@CrossOrigin
@RequestMapping("/rrsInteresting")
public class RrsInterestingController {

    @Resource
    RrsInterestingService interestingService;

    @GetMapping("{CurrentPage}/{PageSize}")
    public R getPage(@PathVariable Integer CurrentPage, @PathVariable Integer PageSize, Interesting interesting) {
        IPage<Interesting> Page = interestingService.getPage(CurrentPage, PageSize, interesting);
        if (CurrentPage > Page.getPages()){
            Page = interestingService.getPage((int)Page.getPages(), PageSize, interesting);
        }
        return new R((null != Page), Page);
    }

    @GetMapping
    public R getAll(){
        return new R(true, interestingService.list());
    }

    @PostMapping
    public R save(@RequestBody Interesting interesting){
        return new R(true, interestingService.save(interesting));
    }

    /*@DeleteMapping
    public R delete(Interesting interesting){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("interesting", interesting.getInteresting());
        return new R(true, interestingService.remove(qw));
    }*/

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(interestingService.removeById(id));
    }

    @PutMapping
    public R update(@RequestBody Interesting interesting) {
        return new R(interestingService.updateById(interesting));
    }

}

