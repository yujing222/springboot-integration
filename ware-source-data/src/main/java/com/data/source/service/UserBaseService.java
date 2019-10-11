package com.data.source.service;

import com.data.source.entity.UserBase;

public interface UserBaseService {

    UserBase selectByPrimaryKey(Integer id) ;

    void insert (UserBase record);
}
