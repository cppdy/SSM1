package com.jeff.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeff.dao.JedisClusterDao;
import com.jeff.entity.User;
import com.jeff.mapper.UserMapper;
import com.jeff.service.UserService;
import com.jeff.utils.CookieUtils;
import com.jeff.utils.JsonUtils;

/**
 * @description: 用户service实现类
 * @author: Jeff
 * @date: 2019年02月20日 22:58:29
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JedisClusterDao jedisClusterDao;

    @Override
    public List<User> selByPage(User user) {

        return userMapper.selByPage(user);
    }

    @Override
    public boolean insUser(User user) {

        return userMapper.insUser(user) > 0;
    }

    @Override
    public boolean delUser(int id) {

        return userMapper.delUser(id) > 0;
    }

    @Override
    public User selUserById(int id) {

        return userMapper.selUserById(id);
    }

    @Override
    public boolean updUser(User user) {

        return userMapper.updUser(user) > 0;
    }

    @Override
    public boolean login(User user, HttpServletRequest request, HttpServletResponse response) {
        User u = userMapper.login(user);
        if (null != u) {
            // 可以把密码清空
            u.setPassword(null);
            // 当用户登录成功后把用户信息放入到redis中
            String key = UUID.randomUUID().toString();
            jedisClusterDao.set(key, JsonUtils.objectToJson(u));
            jedisClusterDao.expire(key, 60 * 60 * 24 * 7);
            // 产生cookie
            CookieUtils.setCookie(request, response, "TT_TOKEN", key, 60 * 60 * 24 * 7);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object getUserInfoByToken(String token) {
        String json = jedisClusterDao.get(token);
        User user = JsonUtils.jsonToPojo(json, User.class);
        return user;
    }

}
