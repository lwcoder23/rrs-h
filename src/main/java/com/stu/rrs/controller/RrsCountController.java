package com.stu.rrs.controller;

import com.stu.rrs.controller.utils.R;
import com.stu.rrs.entity.Count;
import com.stu.rrs.service.RrsCountService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/count")
public class RrsCountController {

    @Resource
    RrsCountService countService;

    @GetMapping
    public List<Count> getAll() {
        return countService.list();
    }

}
