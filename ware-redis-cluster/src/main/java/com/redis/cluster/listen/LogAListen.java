package com.redis.cluster.listen;

import com.redis.cluster.config.RedisLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class LogAListen implements RedisHandler {

    private static final Logger LOG = LoggerFactory.getLogger(LogAListen.class) ;
    @Resource
    private RedisLock redisLock;
    @Override
    public String queueName() {
        return "LogA-key";
    }
    @Override
    public String consume(String msgBody) {
        // 加锁，防止消息重复投递
        String lockKey = "lock-order-uuid-A";
        boolean lock = false;
        try {
            lock = redisLock.addLock(lockKey, 60);
            if (!lock) {
                return "success";
            }
            LOG.info("LogA-key == >>" + msgBody);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (lock) {
                redisLock.removeLock(lockKey);
            }
        }
        return "success";
    }
}
