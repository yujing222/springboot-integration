package com.drool.engine.service;

import com.drool.engine.entity.QueryParam;

public interface RuleEngineService {
    void executeAddRule (QueryParam param) ;
    void executeRemoveRule (QueryParam param) ;
}
