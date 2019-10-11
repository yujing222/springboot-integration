package com.plus.batis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.plus.batis.mapper"})
public class Application7014 {
    public static void main(String[] args) {
        SpringApplication.run(Application7014.class,args) ;
    }
}
