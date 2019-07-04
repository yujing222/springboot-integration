package com.redis.cluster.controller;

import com.alibaba.fastjson.JSONObject;
import com.redis.cluster.service.RedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import javax.annotation.Resource;
import java.util.Date;

@RestController
public class RedisController {

    @Resource
    private RedisService redisService ;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private JedisSentinelPool jedisSentinelPool;

    @RequestMapping("/increment")
    public String increment (){
        stringRedisTemplate.opsForValue().increment("cicada-key",10L) ;
        return "success" ;
    }

    @RequestMapping("/sentinel")
    public String sentinel (){
        Jedis jedis = jedisSentinelPool.getResource() ;
        jedis.set("sentinel","sentinel") ;
        return "success" ;
    }

    /**
     * 队列推消息
     */
    @RequestMapping("/saveQueue")
    public String saveQueue (){
        MsgBody msgBody = new MsgBody() ;
        msgBody.setName("LogAModel");
        msgBody.setDesc("描述");
        msgBody.setCreateTime(new Date());
        redisService.saveQueue("LogA-key", JSONObject.toJSONString(msgBody));
        return "success" ;
    }
}
