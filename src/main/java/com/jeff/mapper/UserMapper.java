package com.jeff.mapper;

import java.util.List;

import com.jeff.entity.User;

/**
 * @description: 用户mapper接口
 * @author: Jeff
 * @date: 2019年02月20日 23:10:29
 */
public interface UserMapper {
    /**
     * @description: 获取用户列表数据
     * @param user
     * @return List<User>
     * @author: Jeff
     * @date: 2019年02月20日 23:10:49
     */
    List<User> selByPage(User user);

    /**
     * @description: 新增用户
     * @param user
     * @return int
     * @author: Jeff
     * @date: 2019年02月20日 23:11:05
     */
    int insUser(User user);

    /**
     * @description: 删除用户
     * @param id
     * @return int
     * @author: Jeff
     * @date: 2019年02月20日 23:11:18
     */
    int delUser(int id);

    /**
     * @description: 根据id获取用户信息
     * @param id
     * @return User
     * @author: Jeff
     * @date: 2019年02月20日 23:11:31
     */
    User selUserById(int id);

    /**
     * @description: 编辑用户
     * @param user
     * @return int
     * @author: Jeff
     * @date: 2019年02月20日 23:11:44
     */
    int updUser(User user);

    /**
     * @description: 用户登陆
     * @param user
     * @return User
     * @author: Jeff
     * @date: 2019年02月20日 23:11:58
     */
    User login(User user);

}
