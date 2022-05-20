package com.stu.rrs.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {

    private Boolean flag;

    private Object data;

    private String msg;

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(String msg){
        this.msg = msg;
    }

    public R(Object data){
        this.data = data;
    }

    public R(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

}
