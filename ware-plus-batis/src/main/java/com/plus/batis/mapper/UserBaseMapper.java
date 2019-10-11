package com.plus.batis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.plus.batis.entity.QueryParam;
import com.plus.batis.entity.UserBase;
import java.util.List;

public interface UserBaseMapper extends BaseMapper<UserBase> {

    List<UserBase> selectByParam (QueryParam param) ;

}