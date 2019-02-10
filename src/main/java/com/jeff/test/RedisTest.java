package com.jeff.test;

import redis.clients.jedis.Jedis;

public class RedisTest {

    public static void main(String[] args) {

        // 连接redis服务器，192.168.1.104:6379
        Jedis jedis = new Jedis("192.168.1.104", 6379);
        // 向redis存入数据
        jedis.set("redisTest", "测试redis");
        // 从redis获取数据
        System.out.println(jedis.get("redisTest"));
        // 根据key删除redis数据
        jedis.del("redisTest");
        System.out.println(jedis.get("redisTest"));
    }

}
