package com.stu.rrs.controller;

import com.stu.rrs.controller.utils.R;
import com.stu.rrs.service.RrsRotationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/rrsRotation")
public class RrsRotationController {
    @Resource
    RrsRotationService rotationService;

    @GetMapping
    public R getAll(){
        return new R(true, rotationService.list());
    }

}
