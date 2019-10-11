package com.data.source.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.data.source.mapper.one"},sqlSessionTemplateRef = "sqlSessionTemplateOne")
public class DruidOneConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DruidOneConfig.class) ;

    @Resource
    private DruidOneParam druidOneParam ;

    @Bean("dataSourceOne")
    public DataSource dataSourceOne () {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(druidOneParam.getDbUrl());
        datasource.setUsername(druidOneParam.getUsername());
        datasource.setPassword(druidOneParam.getPassword());
        datasource.setDriverClassName(druidOneParam.getDriverClassName());
        datasource.setInitialSize(druidOneParam.getInitialSize());
        datasource.setMinIdle(druidOneParam.getMinIdle());
        datasource.setMaxActive(druidOneParam.getMaxActive());
        datasource.setMaxWait(druidOneParam.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(druidOneParam.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(druidOneParam.getMinEvictableIdleTimeMillis());
        datasource.setMaxEvictableIdleTimeMillis(druidOneParam.getMaxEvictableIdleTimeMillis());
        datasource.setValidationQuery(druidOneParam.getValidationQuery());
        datasource.setTestWhileIdle(druidOneParam.isTestWhileIdle());
        datasource.setTestOnBorrow(druidOneParam.isTestOnBorrow());
        datasource.setTestOnReturn(druidOneParam.isTestOnReturn());
        datasource.setPoolPreparedStatements(druidOneParam.isPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(druidOneParam.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            datasource.setFilters(druidOneParam.getFilters());
        } catch (Exception e) {
            LOGGER.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(druidOneParam.getConnectionProperties());
        return datasource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryOne() throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setDataSource(dataSourceOne());
        factory.setMapperLocations(resolver.getResources("classpath*:/dataOneMapper/*.xml"));
        return factory.getObject();
    }

    @Bean(name="transactionManagerOne")
    public DataSourceTransactionManager transactionManagerOne(){
        return  new DataSourceTransactionManager(dataSourceOne());
    }

    @Bean(name = "sqlSessionTemplateOne")
    public SqlSessionTemplate sqlSessionTemplateOne() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryOne());
    }

}
