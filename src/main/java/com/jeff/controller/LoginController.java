package com.jeff.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.entity.User;
import com.jeff.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("loginPage")
    public Object loginPage() {

        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public Object login(User user, HttpServletRequest request, HttpServletResponse response) {

        return userService.login(user, request, response);
    }
    
    @RequestMapping("getUserInfo")
    @ResponseBody
    public Object getUserInfoByToken(String token) {

        return userService.getUserInfoByToken(token);
    }

}
