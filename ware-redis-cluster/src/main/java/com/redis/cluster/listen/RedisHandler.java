package com.redis.cluster.listen;

public interface RedisHandler  {
    /**
     * 队列名称
     */
    String queueName();

    /**
     * 队列消息内容
     */
    String consume (String msgBody);
}
