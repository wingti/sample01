package com.example.sample01.service;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginVO implements Serializable {
    String userid;
    String username;
    String realname;
}
