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
    public void insDemo() {
        User user = new User();
        user.setLoginName("cs0129");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserType(0);
        user.setStatus(0);
        userMapper.insUser(user);

        // int num = 6 / 0;

        user.setId(12L);
        user.setLoginName("xgcs0129");
        user.setPassword("xg123456");
        userMapper.updUser(user);

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
