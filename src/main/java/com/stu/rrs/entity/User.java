package com.stu.rrs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String userName;

    private String psd;

    private String role;

    private String interesting;

    private String phone;

    public User(String userName) {
        this.userName = userName;
    }

    public User(Integer id) {
        this.id = id;
    }
}
