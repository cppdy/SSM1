package com.jeff.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.entity.User;
import com.jeff.service.UserService;

/**
 * @description: 用户登陆controller类
 * @author: Jeff
 * @date: 2019年02月20日 23:04:20
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * @description: 用户登陆界面
     * @return Object
     * @author: Jeff
     * @date: 2019年02月20日 23:03:19
     */
    @RequestMapping("loginPage")
    public Object loginPage() {

        return "login";
    }

    /**
     * @description: 用户登陆
     * @param user
     * @param request
     * @param response
     * @return Object
     * @author: Jeff
     * @date: 2019年02月20日 23:04:37
     */
    @RequestMapping("login")
    @ResponseBody
    public Object login(User user, HttpServletRequest request, HttpServletResponse response) {

        return userService.login(user, request, response);
    }

    /**
     * @description: 根据token获取用户信息
     * @param token
     * @return Object
     * @author: Jeff
     * @date: 2019年02月20日 23:04:48
     */
    @RequestMapping("getUserInfo")
    @ResponseBody
    public Object getUserInfoByToken(String token) {

        return userService.getUserInfoByToken(token);
    }

}
