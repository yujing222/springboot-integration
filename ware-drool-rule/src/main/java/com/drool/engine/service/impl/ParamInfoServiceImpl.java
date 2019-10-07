package com.drool.engine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drool.engine.entity.ParamInfo;
import com.drool.engine.mapper.ParamInfoMapper;
import com.drool.engine.service.ParamInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("paramInfoService")
public class ParamInfoServiceImpl extends ServiceImpl<ParamInfoMapper,ParamInfo> implements ParamInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParamInfoServiceImpl.class) ;

    @Resource
    private ParamInfoMapper paramInfoMapper ;

    @Override
    public ParamInfo selectById (String paramId){
        ParamInfo paramInfo = paramInfoMapper.selectById(paramId) ;
        LOGGER.info("ParamInfoServiceImpl-Sign：{}",paramInfo.getParamSign());
        return paramInfo ;
    }

    @Override
    public void insertParam(ParamInfo paramInfo) {
        paramInfoMapper.insertParam(paramInfo) ;
    }

}
