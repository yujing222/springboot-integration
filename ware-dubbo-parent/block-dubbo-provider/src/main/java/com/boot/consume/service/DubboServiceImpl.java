package com.boot.consume.service;

import com.boot.common.DubboService;
import com.alibaba.dubbo.config.annotation.Service;
import com.boot.common.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/*
 * 注意这里的注解
 * com.alibaba.dubbo.config.annotation.Service
 */
@Service(timeout = 2000)
@Component
public class DubboServiceImpl implements DubboService {

    private static Logger LOGGER = LoggerFactory.getLogger(DubboServiceImpl.class) ;

    @Override
    public String getInfo(String param) {
        LOGGER.info("字符参数：{}",param);
        return "[Hello,Cicada]";
    }

    @Override
    public UserEntity getUserInfo(UserEntity userEntity) {
        LOGGER.info("实体类参数：{}",userEntity);
        return userEntity;
    }

    @Override
    public String timeOut(Integer time) {
        LOGGER.info("超时测试：{}",time);
        try{
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
            return "超时了..." ;
        }
        return "SUCCESS";
    }
}
