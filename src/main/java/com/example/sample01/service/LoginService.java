package com.example.sample01.service;

import com.example.sample01.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public LoginVO getUserData(String username, String password){
        HashMap map = new HashMap<String,String>();
        map.put("username",username);
        map.put("password",password);
        LoginVO loginvo = loginMapper.getUserData(map);

        return loginvo;
    }
}
