package com.plus.batis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.plus.batis.entity.QueryParam;
import com.plus.batis.entity.UserBase;
import com.plus.batis.mapper.UserBaseMapper;
import com.plus.batis.service.UserBaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserBaseServiceImpl extends ServiceImpl<UserBaseMapper,UserBase> implements UserBaseService {

    @Resource
    private UserBaseMapper userBaseMapper ;

    @Override
    public IPage<UserBase> queryPage(QueryParam param) {

        IPage<UserBase> pageData = this.page(
            new Page<>(param.getPage(),param.getPageSize()),
            new QueryWrapper<UserBase>()
                .like(StringUtils.isNotBlank(param.getUserName()),"user_name", param.getUserName())
                .eq(param.getState() != null,"state",param.getState())
        );

        return pageData ;
    }

    @Override
    public PageInfo<UserBase> pageHelper(QueryParam param) {
        PageHelper.startPage(1,2) ;
        List<UserBase> userBaseList = userBaseMapper.selectByParam(param) ;
        PageInfo<UserBase> pageInfo = new PageInfo<>(userBaseList) ;
        return pageInfo ;
    }
}
