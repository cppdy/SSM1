package com.jeff.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.jeff.dao.JedisClusterDao;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Repository
public class JedisClusterDaoImpl implements JedisClusterDao {
    @Resource
    private JedisPool jedisPool;

    @Override
    public Boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        Boolean string = jedis.exists(key);
        jedis.close();
        return string;
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.get(key);
        jedis.close();
        return string;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.set(key, value);
        jedis.close();
        return string;
    }

    @Override
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long string = jedis.del(key);
        jedis.close();
        return string;
    }

    @Override
    public Long expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key, seconds);
        jedis.close();
        return result;
    }
}
