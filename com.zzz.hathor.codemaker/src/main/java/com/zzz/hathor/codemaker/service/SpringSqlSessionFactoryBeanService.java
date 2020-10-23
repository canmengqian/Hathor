package com.zzz.hathor.codemaker.service;

import com.zzz.hathor.codemaker.domain.vo.query.DataSourceInfoQuery;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
@Service
public interface SpringSqlSessionFactoryBeanService {
    public void assemberSqlSessionFactoryBean(DataSourceInfoQuery dataSourceInfoQuery) ;
}
