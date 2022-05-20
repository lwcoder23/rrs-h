package com.stu.rrs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stu.rrs.dao.RrsRotationDao;
import com.stu.rrs.entity.Rotation;
import com.stu.rrs.service.RrsRotationService;
import org.springframework.stereotype.Service;

@Service
public class RrsRotationServiceImpl extends ServiceImpl<RrsRotationDao, Rotation> implements RrsRotationService {
}
