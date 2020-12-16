package com.unicorn.um.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer gender;
    private Date registerTime;
}
