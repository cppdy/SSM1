package com.jeff.dao;

public interface JedisClusterDao {

    /**
     * @description: 判断key是否存在
     * @param key
     * @return Boolean
     * @author: Jeff
     * @date: 2019年02月20日 23:08:01
     */
    Boolean exists(String key);

    /**
     * @description: 删除
     * @param key
     * @return Long
     * @author: Jeff
     * @date: 2019年02月20日 23:08:13
     */
    Long del(String key);

    /**
     * 
     * @description: 设置值
     * @param key
     * @param value
     * @return String
     * @author: Jeff
     * @date: 2019年02月20日 23:08:23
     */
    String set(String key, String value);

    /**
     * @description: 取值
     * @param key
     * @return String
     * @author: Jeff
     * @date: 2019年02月20日 23:08:33
     */
    String get(String key);

    /**
     * @description: 设置key的过期时间
     * @param key
     * @param seconds
     * @return Long
     * @author: Jeff
     * @date: 2019年02月20日 23:08:43
     */
    Long expire(String key, int seconds);
}
