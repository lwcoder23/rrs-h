package com.stu.rrs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Integer id;

    private Integer uid;

    private String userName;

    private Integer rid;

    private String restaurantName;

    private String text;

    private String score1;

    private String score2;

    private String score3;

    private String img1;

    private String img2;

    private String img3;

    private String img4;

    private String img5;

}
