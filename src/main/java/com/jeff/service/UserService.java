package com.jeff.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeff.entity.User;

public interface UserService {

    List<User> selByPage(User user);

    boolean insUser(User user);

    boolean delUser(int id);

    User selUserById(int id);

    boolean updUser(User user);

    void insDemo();

    boolean login(User user, HttpServletRequest request, HttpServletResponse response);

    Object getUserInfoByToken(String token);

}
