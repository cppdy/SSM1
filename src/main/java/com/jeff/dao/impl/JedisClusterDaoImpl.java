package com.jeff.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.jeff.dao.JedisClusterDao;

import redis.clients.jedis.JedisCluster;

@Repository
public class JedisClusterDaoImpl implements JedisClusterDao {
    @Resource
    private JedisCluster jedisCluster;

    @Override
    public Boolean exists(String key) {

        return jedisCluster.exists(key);
    }

    @Override
    public String get(String key) {

        return jedisCluster.get(key);
    }

    @Override
    public String set(String key, String value) {

        return jedisCluster.set(key, value);
    }

    @Override
    public Long del(String key) {

        return jedisCluster.del(key);
    }

    @Override
    public Long expire(String key, int seconds) {

        return jedisCluster.expire(key, seconds);
    }
}
