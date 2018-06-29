package com.example.sample01.controller;

import com.example.sample01.service.LoginService;
import com.example.sample01.service.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


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
    public String doLogin(ModelMap modelMap,  HttpServletRequest request){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginVO loginvo = loginService.getUserData(username, password);
        if(loginvo != null){
            request.getSession().setAttribute("userid",loginvo.getUserid());
            modelMap.addAttribute("username",loginvo.getUsername());
            modelMap.addAttribute("realname",loginvo.getUsername());
        }
        return "main";
    }
}
