package com.stu.rrs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stu.rrs.controller.utils.Eclat;
import com.stu.rrs.controller.utils.R;
import com.stu.rrs.entity.Count;
import com.stu.rrs.entity.Recommend;
import com.stu.rrs.entity.Restaurant;
import com.stu.rrs.service.RrsCountService;
import com.stu.rrs.service.RrsRecommendService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recommend")
public class RrsRecommendController {

    @Resource
    RrsCountService countService;

    @Resource
    RrsRecommendService recommendService;

    @GetMapping("{CurrentPage}/{PageSize}")
    public R res(@PathVariable Integer CurrentPage, @PathVariable Integer PageSize, Recommend recommend) {
        IPage<Recommend> Page = recommendService.getPage(CurrentPage, PageSize, recommend);
        if (CurrentPage > Page.getPages()){
            Page = recommendService.getPage((int)Page.getPages(), PageSize, recommend);
        }
        return new R((null != Page), Page);
    }

    @GetMapping("{c1}")
    public R getByClassify(@PathVariable String c1) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("c1", c1);
        return new R(recommendService.getOne(qw));
    }

    @PutMapping
    public R recommended(@RequestBody Recommend recommend) {
        Recommend re = recommend;
        UpdateWrapper<Recommend> uw = new UpdateWrapper<>();
        int sup = Integer.parseInt(re.getSup());
        int cof = Integer.parseInt(re.getCof());
        if (sup > 99 || cof > 99) {
            uw.eq("state", "1").set("state", "0");
        } else {
            uw.eq("state", "0").set("state", "1");
        }
        return new R(recommendService.update(uw));
    }

    /*@PutMapping
    public R recommend() {
        List<Count> list = countService.list();
        Iterator<Count> it = list.iterator();
        ArrayList<String> transList = new ArrayList<>();
        while (it.hasNext()) {
            String str = it.next().getUid().toString();
            if (it.next().getC1() != null && it.next().getC1() != "") {
                str += ";c1";
            }
            if (it.next().getC2() != null && it.next().getC2() != "") {
                str += ";c2";
            }
            if (it.next().getC3() != null && it.next().getC3() != "") {
                str += ";c3";
            }
            if (it.next().getC4() != null && it.next().getC4() != "") {
                str += ";c4";
            }
            if (it.next().getC5() != null && it.next().getC5() != "") {
                str += ";c5";
            }
            if (it.next().getC6() != null && it.next().getC6() != "") {
                str += ";c6";
            }
            if (it.next().getC7() != null && it.next().getC7() != "") {
                str += ";c7";
            }
            if (it.next().getC8() != null && it.next().getC8() != "") {
                str += ";c8";
            }
            transList.add(str);
        }

        Eclat eclat = new Eclat();
        List<String> fItems = eclat.getFItems();
        return new R(true, fItems);
    }*/

}
