package com.security.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /**
     * 首页
     */
    @RequestMapping("/")
    public String index (){
        return "home" ;
    }
    /**
     * 登录页
     */
    @RequestMapping("/userLogin")
    public String loginPage (){
        return "pages/login" ;
    }
    /**
     * page1 下页面
     */
    @PreAuthorize("hasAuthority('LEVEL1')")
    @RequestMapping("/page1/{pageName}")
    public String onePage (@PathVariable("pageName") String pageName){
        return "pages/page1/"+pageName ;
    }
    /**
     * page2 下页面
     */
    @PreAuthorize("hasAuthority('LEVEL2')")
    @RequestMapping("/page2/{pageName}")
    public String twoPage (@PathVariable("pageName") String pageName){
        return "pages/page2/"+pageName ;
    }
    /**
     * page3 下页面
     */
    @PreAuthorize("hasAuthority('LEVEL3')")
    @RequestMapping("/page3/{pageName}")
    public String threePage (@PathVariable("pageName") String pageName){
        return "pages/page3/"+pageName ;
    }
}
