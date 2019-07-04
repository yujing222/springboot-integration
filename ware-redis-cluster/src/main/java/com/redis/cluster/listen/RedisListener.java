package com.redis.cluster.listen;

import com.redis.cluster.utils.SpringUtil;
import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RedisListener implements InitializingBean {
    /**
     * Redis 集群
     */
    @Resource
    private JedisSentinelPool jedisSentinelPool;
    private List<RedisHandler> handlers = null;
    private ExecutorService product = null;
    private ExecutorService consumer = null;
    /**
     * 初始化配置
     */
    @Override
    public void afterPropertiesSet() {
        handlers = SpringUtil.getBeans(RedisHandler.class) ;
        product = new ThreadPoolExecutor(10,15,60 * 3,
                TimeUnit.SECONDS,new SynchronousQueue<>());
        consumer = new ThreadPoolExecutor(10,15,60 * 3,
                TimeUnit.SECONDS,new SynchronousQueue<>());
        for (RedisHandler redisHandler : handlers){
            product.execute(() -> {
                redisTask(redisHandler);
            });
        }
    }
    /**
     * 队列监听
     */
    public void redisTask (RedisHandler redisHandler){
        Jedis jedis = null ;
        while (true){
            try {
                jedis = jedisSentinelPool.getResource() ;
                List<String> msgBodyList = jedis.brpop(0, redisHandler.queueName());
                if (msgBodyList != null && msgBodyList.size()>0){
                    consumer.execute(() -> {
                        redisHandler.consume(msgBodyList.get(1)) ;
                    });
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                if (jedis != null) jedis.close();
            }
        }
    }
}
