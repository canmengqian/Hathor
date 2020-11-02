package com.zzz.hathor.codemaker.service;

import com.zzz.hathor.codemaker.domain.vo.query.DataSourceInfoQuery;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;

@Service
public interface SpringSqlSessionFactoryBeanService {
    /**
     * 组装sqlSessionFactory
     * @param dataSourceInfoQuery
     */
    public SqlSessionFactoryBean assemberSqlSessionFactoryBean(DataSourceInfoQuery dataSourceInfoQuery, String beanName) throws IOException;

    public static  final String MAPPER_LOCATION_PREFIX = "classpath*:/com/zzz/hathor/codemaker/mapper/";

    public static  final String MAPPER_LOCATION_SUFFIX = "/*-Mapper.xml";
}
