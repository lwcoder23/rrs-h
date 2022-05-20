package com.stu.rrs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect {

    private Integer id;

    private Integer uid;

    private Integer rid;

    private String restaurantName;

    private String time;

}
