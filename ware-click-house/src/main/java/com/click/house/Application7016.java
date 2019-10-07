package com.click.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.click.house.mapper"})
public class Application7016 {
    public static void main(String[] args) {
        SpringApplication.run(Application7016.class,args) ;
    }
}
