package com.redis.cluster.service;

public interface RedisService {
    void saveQueue (String queueKey ,String msgBody) ;
}
