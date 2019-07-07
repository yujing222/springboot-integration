package com.boot.consume.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.boot.common.VersionService;
import org.springframework.stereotype.Component;

@Service(version = "1.0.0")
@Component
public class VersionOneImpl implements VersionService {
    @Override
    public String getVersion() {
        return "{当前版本：1.0.0}";
    }
}
