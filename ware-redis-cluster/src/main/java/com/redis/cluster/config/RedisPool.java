package com.redis.cluster.config;

import com.redis.cluster.listen.RedisListener;
import com.redis.cluster.utils.SpringUtil;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisSentinelPool;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableConfigurationProperties(RedisParam.class)
public class RedisPool {

    @Resource
    private RedisParam redisParam ;

    @Bean("jedisSentinelPool")
    public JedisSentinelPool getRedisPool (){
        Set<String> sentinels = new HashSet<>();
        sentinels.addAll(Arrays.asList(redisParam.getNodes().split(",")));
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(redisParam.getMaxTotal());
        poolConfig.setMinIdle(redisParam.getMinIdle());
        poolConfig.setMaxWaitMillis(redisParam.getMaxWaitMillis());
        poolConfig.setTestWhileIdle(redisParam.isTestWhileIdle());
        poolConfig.setTestOnBorrow(redisParam.isTestOnBorrow());
        poolConfig.setTestOnReturn(redisParam.isTestOnReturn());
        poolConfig.setTimeBetweenEvictionRunsMillis(redisParam.getTimeBetweenEvictionRunsMillis());
        JedisSentinelPool redisPool = new JedisSentinelPool(redisParam.getMaster(), sentinels, poolConfig);
        return redisPool;
    }
    @Bean
    SpringUtil springUtil() {
        return new SpringUtil();
    }
    @Bean
    RedisListener redisListener() {
        return new RedisListener();
    }
}
