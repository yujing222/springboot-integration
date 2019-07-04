package com.redis.cluster.service.impl;

import com.redis.cluster.service.RedisService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import javax.annotation.Resource;

@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private JedisSentinelPool jedisSentinelPool;

    @Override
    public void saveQueue(String queueKey, String msgBody) {
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            jedis.lpush(queueKey,msgBody) ;
        } catch (Exception e){
          e.printStackTrace();
        } finally {
            if (jedis != null) jedis.close();
        }
    }
}
