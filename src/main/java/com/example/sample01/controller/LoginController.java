package com.example.sample01.controller;

import com.example.sample01.service.LoginService;
import com.example.sample01.service.LoginVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value="/loginpage", method = RequestMethod.GET)
    public String goLoginPage(){
        System.out.println("test");
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String doLogin(ModelMap modelMap,  HttpServletRequest request) throws Exception{
        String data = readBody(request);
        HashMap<String,String> result = new ObjectMapper().readValue(data, HashMap.class);
        String username = result.get("username");
        String password = result.get("password");
        LoginVO loginvo = loginService.getUserData(username, password);
        if(loginvo != null){
            request.getSession().setAttribute("userid",loginvo.getUserid());
            modelMap.addAttribute("username",loginvo.getUsername());
            modelMap.addAttribute("realname",loginvo.getUsername());
        }
        return "main";
    }

    public static String readBody(HttpServletRequest request) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(buffer);
        }
        return builder.toString();
    }
}
