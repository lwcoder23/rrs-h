package com.stu.rrs.controller;

import com.stu.rrs.controller.utils.R;
import com.stu.rrs.controller.utils.UploadUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class UpLoadController {

    @RequestMapping("/upload")
    public R upload(@RequestBody MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        UploadUtils uploadUtils = new UploadUtils();
        String upload = uploadUtils.upload(file);
        return new R(upload);
    }

}
