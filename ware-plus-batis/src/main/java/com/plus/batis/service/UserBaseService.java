package com.plus.batis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.plus.batis.entity.QueryParam;
import com.plus.batis.entity.UserBase;

public interface UserBaseService extends IService<UserBase> {
    IPage<UserBase> queryPage(QueryParam param) ;

    PageInfo<UserBase> pageHelper (QueryParam param) ;
}
