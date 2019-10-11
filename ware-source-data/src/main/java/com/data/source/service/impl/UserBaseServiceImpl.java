package com.data.source.service.impl;

import com.data.source.entity.UserBase;
import com.data.source.mapper.two.UserBaseMapper;
import com.data.source.service.UserBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service
public class UserBaseServiceImpl implements UserBaseService {

    @Resource
    private UserBaseMapper userBaseMapper ;

    @Override
    public UserBase selectByPrimaryKey(Integer id) {
        return userBaseMapper.selectByPrimaryKey(id);
    }

    // 使用指定数据源的事务
    @Transactional(value = "transactionManagerTwo")
    @Override
    public void insert(UserBase record) {
        // 这里数据写入失败
        userBaseMapper.insert(record) ;
        // int i = 1/0 ;
    }

}
