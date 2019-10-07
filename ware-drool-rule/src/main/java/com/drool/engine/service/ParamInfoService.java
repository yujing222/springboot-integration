package com.drool.engine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.drool.engine.entity.ParamInfo;

public interface ParamInfoService extends IService<ParamInfo> {
    ParamInfo selectById (String paramId) ;
    void insertParam (ParamInfo paramInfo) ;
}
