package com.shard.jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableTransactionManagement
@MapperScan("com.shard.jdbc.mapper")
public class ShardJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardJdbcApplication.class, args);
    }
}