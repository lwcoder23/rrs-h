package com.stu.rrs.controller;

import com.stu.rrs.controller.utils.R;
import com.stu.rrs.entity.User;
import com.stu.rrs.service.RrsUsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class RrsLoginController {

    @Resource
    RrsUsersService rrsUsersService;

    @PostMapping
    public R login(@RequestBody User user){
        return rrsUsersService.verifyLogin(user);
    }

}
