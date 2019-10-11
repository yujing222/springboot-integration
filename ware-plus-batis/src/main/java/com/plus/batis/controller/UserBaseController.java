package com.plus.batis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.plus.batis.entity.QueryParam;
import com.plus.batis.entity.UserBase;
import com.plus.batis.service.UserBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserBaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserBaseController.class) ;

    @Resource
    private UserBaseService userBaseService ;

    @RequestMapping("/info")
    public UserBase getUserBase (){
        return userBaseService.getById(1) ;
    }

    @RequestMapping("/queryInfo")
    public String queryInfo (){

        UserBase userBase1 = userBaseService.getOne(new QueryWrapper<UserBase>().orderByDesc("create_time")) ;
        LOGGER.info("倒叙取值：{}",userBase1.getUserName());

        Integer count = userBaseService.count() ;
        LOGGER.info("查询总数：{}",count);

        UserBase userBase2 = new UserBase() ;
        userBase2.setId(1);
        userBase2.setUserName("spring");
        boolean resFlag = userBaseService.saveOrUpdate(userBase2) ;
        LOGGER.info("保存更新：{}",resFlag);

        Map<String, Object> listByMap = new HashMap<>() ;
        listByMap.put("state","0") ;
        Collection<UserBase> listMap = userBaseService.listByMap(listByMap) ;
        LOGGER.info("ListByMap查询：{}",listMap);

        boolean removeFlag = userBaseService.removeById(3) ;
        LOGGER.info("删除数据：{}",removeFlag);

        return "success" ;
    }

    @RequestMapping("/queryPage")
    public IPage<UserBase> queryPage (){
        QueryParam param = new QueryParam() ;
        param.setPage(1);
        param.setPageSize(10);
        param.setUserName("cicada");
        param.setState(0);
        return userBaseService.queryPage(param) ;
    }

    @RequestMapping("/pageHelper")
    public PageInfo<UserBase> pageHelper (){
        return userBaseService.pageHelper(new QueryParam()) ;
    }

}
