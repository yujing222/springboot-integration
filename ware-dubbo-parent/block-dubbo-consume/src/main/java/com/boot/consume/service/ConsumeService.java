package com.boot.consume.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.common.DubboService;
import com.boot.common.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class ConsumeService implements DubboService {

    @Reference
    private DubboService dubboService ;

    @Override
    public String getInfo(String param) {
        return dubboService.getInfo(param);
    }

    @Override
    public UserEntity getUserInfo(UserEntity userEntity) {
        return dubboService.getUserInfo(userEntity);
    }

    @Override
    public String timeOut(Integer time) {
        return dubboService.timeOut(time);
    }
}
