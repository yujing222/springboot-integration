package com.boot.consume.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.boot.common.VersionService;
import org.springframework.stereotype.Component;

@Service(version = "2.0.0")
@Component
public class VersionTwoImpl implements VersionService {
    @Override
    public String getVersion() {
        return "{当前版本：2.0.0}";
    }
}
