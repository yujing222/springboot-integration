package com.redis.cluster.config;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import javax.annotation.Resource;

@Component
public class RedisLock {
    private static String keyPrefix = "RedisLock:";
    @Resource
    private JedisSentinelPool jedisSentinelPool;

    public boolean addLock(String key, long expire) {
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            /*
             * nxxx的值只能取NX或者XX，如果取NX，则只有当key不存在是才进行set，如果取XX，则只有当key已经存在时才进行set
             * expx的值只能取EX或者PX，代表数据过期时间的单位，EX代表秒，PX代表毫秒。
             */
            String value = jedis.set(keyPrefix + key, "1", "nx", "ex", expire);
            return value != null;
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) jedis.close();
        }
        return false;
    }

    public void removeLock(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            jedis.del(keyPrefix + key);
        } finally {
            if (jedis != null) jedis.close();
        }
    }
}
