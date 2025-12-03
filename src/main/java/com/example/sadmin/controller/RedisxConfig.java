package com.example.sadmin.controller;

import org.noear.redisx.RedisClient;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Inject;

/**
 * Redisx 配置类
 */
public class RedisxConfig {
    /**
     * 构建RedisClient Bean
     * @visduo
     *
     * @Bean：构建一个Bean对象
     * @Inject：将redis.rd1配置信息注入给RedisClient
     *
     * @param client 注入RedisClient
     * @return RedisClient
     */
    @Bean
    public RedisClient redisClient(@Inject("${test.rd1}") RedisClient client) {
        return client;
    }
}
