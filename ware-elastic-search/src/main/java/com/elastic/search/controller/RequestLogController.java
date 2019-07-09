package com.elastic.search.controller;

import com.elastic.search.model.RequestLog;
import com.elastic.search.service.RequestLogService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Optional;

@RestController
public class RequestLogController {

    @Resource
    private RequestLogService requestLogService ;

    /**
     * 数据入库 Elastic
     */
    @RequestMapping("/insert")
    public String insert (){
        return requestLogService.esInsert(10) ;
    }

    /**
     * 查询全部 Elastic
     */
    @RequestMapping("/findAll")
    public Iterable<RequestLog> findAll (){
        return requestLogService.esFindAll() ;
    }

    /**
     * 根据ID修改
     * ID:1560406811693
     */
    @RequestMapping("/updateById/{id}")
    public String updateById (@PathVariable Long id){
        RequestLog requestLog = new RequestLog() ;
        requestLog.setId(id);
        requestLog.setUserName("updateName");
        return requestLogService.esUpdateById(requestLog) ;
    }

    /**
     * 根据ID查询
     */
    @RequestMapping("/selectById/{id}")
    public RequestLog selectById (@PathVariable Long id){
        Optional<RequestLog> requestLog = requestLogService.esSelectById(id) ;
        return requestLog.get() ;
    }

    /**
     * 根据指定条件排序
     */
    @RequestMapping("/selectOrder")
    public Iterable<RequestLog> selectOrder (){
        return requestLogService.esFindOrder() ;
    }

    /**
     * 多条件排序
     */
    @RequestMapping("/selectOrders")
    public Iterable<RequestLog> selectOrders (){
        return requestLogService.esFindOrders() ;
    }

    /**
     * 多条件 + 范围 搜索
     */
    @RequestMapping("/search")
    public Iterable<RequestLog> search (){
        return requestLogService.search() ;
    }

    /**
     * 分页查询
     */
    public void findPage (){

    }
}
