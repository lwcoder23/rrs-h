package com.stu.rrs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommend {

    private Integer id;

    private String c1;

    private String c2;

    private String c3;

    private String mount;

    private String sup;

    private String cof;

    private String state;

}
