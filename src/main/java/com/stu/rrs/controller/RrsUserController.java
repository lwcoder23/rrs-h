package com.stu.rrs.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stu.rrs.controller.utils.R;
import com.stu.rrs.entity.User;
import com.stu.rrs.service.RrsUsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RrsUsers)表控制层
 *
 * @author makejava
 * @since 2022-03-04 10:44:59
 */
@CrossOrigin
@RestController
@RequestMapping("/rrsUser")
public class RrsUserController {

    @Resource
    RrsUsersService rrsUsersService;

    @GetMapping("{CurrentPage}/{PageSize}")
    public R getPage(@PathVariable Integer CurrentPage, @PathVariable Integer PageSize, User user) {
        IPage<User> Page = rrsUsersService.getPage(CurrentPage, PageSize, user);
        if (CurrentPage > Page.getPages()){
            Page = rrsUsersService.getPage((int)Page.getPages(), PageSize, user);
        }
        return new R((null != Page), Page);
    }

    /*@GetMapping("{userName}")
    public R login(@PathVariable String userName) {
        User user = new User(userName);
        return rrsUsersService.verifyLogin(user);
    }*/

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(rrsUsersService.getById(id));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(rrsUsersService.removeById(id));
    }

    @PutMapping
    public R put(@RequestBody User user) {
        return new R(true, rrsUsersService.updateById(user));
    }

    @PutMapping("{id}")
    public R putRole(@PathVariable Integer id) {
        User user = new User(id);
        user.setRole("1");
        return new R(true, rrsUsersService.updateById(user));
    }

    @PostMapping
    public R reg(@RequestBody User user){
        return new R(rrsUsersService.save(user));
    }

}

