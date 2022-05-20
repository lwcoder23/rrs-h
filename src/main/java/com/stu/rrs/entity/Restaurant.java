package com.stu.rrs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("restaurant")
public class Restaurant {

    private Integer id;

    private String restaurantName;

    private String restaurantAddress;

    private String interesting;

    private Integer score1;

    private Integer score2;

    private Integer score3;

    private String phoneNmu;

    private String commentNmu;

    private String img1;

    private String img2;

    private String img3;

}
