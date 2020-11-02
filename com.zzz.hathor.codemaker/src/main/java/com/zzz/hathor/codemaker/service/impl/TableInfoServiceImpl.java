package com.zzz.hathor.codemaker.service.impl;

import com.zzz.hathor.codemaker.domain.vo.query.DataSourceInfoQuery;
import com.zzz.hathor.codemaker.mapper.RepositoryMapper;
import com.zzz.hathor.codemaker.service.SpringSqlSessionFactoryBeanService;
import com.zzz.hathor.codemaker.service.TableInfoService;
import com.zzz.hathor.codemaker.util.executor.SimplerMapperExecutor;
import com.zzz.hathor.codemaker.util.executor.parse.RequestQueryBeanPaser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TableInfoServiceImpl<M> implements TableInfoService {
    @Autowired
    SpringSqlSessionFactoryBeanService springSqlSessionFactoryBeanService;
    @Override
    public List<M> queryTableMetaInfo(DataSourceInfoQuery query) throws Exception {
        String beanName = RequestQueryBeanPaser.parseBean(query);
        springSqlSessionFactoryBeanService.assemberSqlSessionFactoryBean(query,beanName);
        SimplerMapperExecutor<RepositoryMapper,List> executor = new SimplerMapperExecutor<>(beanName);
       return (List<M>) executor.execut(query);
    }
}
