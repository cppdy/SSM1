package com.jeff.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeff.entity.User;

/**
 * @description: 用户service接口
 * @author: Jeff
 * @date: 2019年02月20日 22:59:21
 */
public interface UserService {

    /**
     * @description: 获取用户列表数据
     * @param user
     * @return List<User>
     * @author: Jeff
     * @date: 2019年02月20日 22:59:45
     */
    List<User> selByPage(User user);

    /**
     * @description: 新增用户
     * @param user
     * @return boolean
     * @author: Jeff
     * @date: 2019年02月20日 23:00:02
     */
    boolean insUser(User user);

    /**
     * @description: 删除用户
     * @param id
     * @return boolean
     * @author: Jeff
     * @date: 2019年02月20日 23:00:41
     */
    boolean delUser(int id);

    /**
     * @description: 根据id获取用户信息
     * @param id
     * @return User
     * @author: Jeff
     * @date: 2019年02月20日 23:01:03
     */
    User selUserById(int id);

    /**
     * @description: 编辑用户
     * @param user
     * @return boolean
     * @author: Jeff
     * @date: 2019年02月20日 23:00:25
     */
    boolean updUser(User user);

    /**
     * @description: 用户登陆
     * @param user
     * @param request
     * @param response
     * @return boolean
     * @author: Jeff
     * @date: 2019年02月20日 23:05:15
     */
    boolean login(User user, HttpServletRequest request, HttpServletResponse response);

    /**
     * @description: 根据token获取用户信息
     * @param token
     * @return Object
     * @author: Jeff
     * @date: 2019年02月20日 23:05:33
     */
    Object getUserInfoByToken(String token);

}
