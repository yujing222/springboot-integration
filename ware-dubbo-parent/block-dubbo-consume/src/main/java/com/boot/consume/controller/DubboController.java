package com.boot.consume.controller;

import com.boot.common.UserEntity;
import com.boot.consume.service.ConsumeService;
import com.boot.consume.service.VersionServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/*

http://localhost:7008/getParam
响应参数：[Hello,Cicada]

http://localhost:7008/getUserInfo
响应参数：{"id":1,"userName":"知了"}

 */
@RestController
public class DubboController {

    @Resource
    private ConsumeService consumeService ;
    @Resource
    private VersionServiceImpl versionService1 ;
    @Resource
    private VersionServiceImpl versionService2 ;

    @RequestMapping("/getParam")
    public String getParam (){
        return consumeService.getInfo("知了...") ;
    }

    @RequestMapping("/getUserInfo")
    public UserEntity getUserInfo (){
        UserEntity userEntity = new UserEntity() ;
        userEntity.setId(1);
        userEntity.setUserName("知了");
        return consumeService.getUserInfo(userEntity) ;
    }

    /**
     * 抛出超时异常
     * com.alibaba.dubbo.remoting.TimeoutException
     */
    @RequestMapping("/timeOut")
    public String timeOut (){
        return consumeService.timeOut(2000) ;
    }

    /**
     * 测试接口版本
     * 启动日志
     * <dubbo:reference object="com.alibaba.dubbo.common.bytecode.proxy1@3ad65"
     * singleton="true"
     * interface="com.boot.common.VersionService"
     * uniqueServiceName="com.boot.common.VersionService:1.0.0"
     * generic="false" version="1.0.0"
     * id="com.boot.common.VersionService" /> has been built.
     */
    @RequestMapping("/getVersion1")
    public String getVersion1 (){
        return versionService1.getVersion() ;
    }

    @RequestMapping("/getVersion2")
    public String getVersion2 (){
        return versionService2.version2() ;
    }
}
