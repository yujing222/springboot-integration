package com.boot.shiro.config;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShiroException {

    @ExceptionHandler(AuthorizationException.class)
    public String authorizationException (){
        return "抱歉您没有权限访问该内容!";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        return "系统异常!";
    }

}