package com.drool.engine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.drool.engine.mapper"})
public class Application7015 {
    public static void main(String[] args) {
        SpringApplication.run(Application7015.class,args) ;
    }
}
