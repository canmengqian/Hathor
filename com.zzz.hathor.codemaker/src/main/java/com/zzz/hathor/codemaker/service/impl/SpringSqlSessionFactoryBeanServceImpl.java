package com.zzz.hathor.codemaker.service.impl;

import com.zaxxer.hikari.HikariDataSource;
import com.zzz.hathor.codemaker.domain.vo.query.DataSourceInfoQuery;
import com.zzz.hathor.codemaker.service.SpringSqlSessionFactoryBeanService;
import com.zzz.hathor.codemaker.util.driver.DriverRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

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
    public SqlSessionFactoryBean assemberSqlSessionFactoryBean(DataSourceInfoQuery query,String beanName) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(setDataSource(query));// 设置数据源
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(new PathMatchingResourcePatternResolver());
        org.springframework.core.io.Resource[] resources = resolver.getResources(getMapperLocation(query.getVender().vender));
        sqlSessionFactoryBean.setMapperLocations(resources);
        // 设置刷新器
        //SpringSqlSessionFactoryRefresher factoryRefresher = new SpringSqlSessionFactoryRefresher(context);
        // 设置bean
        //factoryRefresher.refresh(beanName,sqlSessionFactoryBean);
       return sqlSessionFactoryBean;

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



    private String getMapperLocation(String vender) {
        return MAPPER_LOCATION_PREFIX+vender+MAPPER_LOCATION_SUFFIX;
    }

}
