package com.zzz.hathor.codemaker.service.impl;

import com.zaxxer.hikari.HikariDataSource;
import com.zzz.hathor.codemaker.domain.vo.query.DataSourceInfoQuery;
import com.zzz.hathor.codemaker.service.SpringSqlSessionFactoryBeanService;
import com.zzz.hathor.codemaker.util.SpringSqlSessionFactoryRefresher;
import com.zzz.hathor.codemaker.util.driver.DriverRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @ClassName SpringSqlSessionFactoryBeanServceImpl
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/11 15:22
 * @Version 1.0.0
 **/
@Service
public class SpringSqlSessionFactoryBeanServceImpl implements SpringSqlSessionFactoryBeanService {


    @Resource
    ApplicationContext context;
    @Override
    public void assemberSqlSessionFactoryBean(DataSourceInfoQuery dataSourceInfoQuery) {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(setDataSource(dataSourceInfoQuery));
        SpringSqlSessionFactoryRefresher factoryRefresher = new SpringSqlSessionFactoryRefresher(context);
        String beanName = setBeanName(dataSourceInfoQuery);
        factoryRefresher.refresh(beanName,sqlSessionFactoryBean);
    }


    /**
     * 设置数据源
     * @param dataSourceInfoQuery
     * @return
     */
    private DataSource setDataSource( DataSourceInfoQuery dataSourceInfoQuery) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(DriverRegistry.getDriverName(dataSourceInfoQuery.getVender().vender));
        dataSource.setJdbcUrl(dataSourceInfoQuery.getUrl());
        dataSource.setUsername(dataSourceInfoQuery.getUsername());
        dataSource.setPassword(dataSourceInfoQuery.getPassword());
        dataSource.setMaximumPoolSize(2);
        dataSource.setMinimumIdle(1);
        return  dataSource;
    }

    private String setBeanName(DataSourceInfoQuery dataSourceInfoQuery) {
        StringBuilder builder = new StringBuilder();
        builder.append(dataSourceInfoQuery.getVender());
        builder.append("_");
        builder.append(dataSourceInfoQuery.getUrl());
        builder.append("_");
        builder.append(dataSourceInfoQuery.getUsername());
        return  builder.toString();

    }
}
