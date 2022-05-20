package com.stu.rrs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stu.rrs.dao.RrsCountDao;
import com.stu.rrs.entity.Count;
import com.stu.rrs.service.RrsCountService;
import org.springframework.stereotype.Service;

@Service
public class RrsCountServiceImpl extends ServiceImpl<RrsCountDao, Count> implements RrsCountService {
}
