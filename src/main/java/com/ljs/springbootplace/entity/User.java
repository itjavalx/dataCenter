package com.ljs.springbootplace.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String username;
    private Integer age;
    private String sex;
    private List<User> childs;

}

