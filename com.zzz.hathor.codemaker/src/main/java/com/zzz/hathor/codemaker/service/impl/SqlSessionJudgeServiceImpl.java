package com.zzz.hathor.codemaker.service.impl;

import com.zzz.hathor.codemaker.service.SqlSessionJudgeService;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

/**
 * @ClassName SqlSessionJudgeServiceImpl
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/10 17:22
 * @Version 1.0.0
 **/
public class SqlSessionJudgeServiceImpl implements SqlSessionJudgeService {
    @Autowired
    @Qualifier("sqlSessionFactoryBean")
    private SqlSessionFactoryBean factoryBean;

    @Autowired
    ApplicationContext context;
    @Override
    public SqlSessionFactoryBean createSqlSessionFactoryBean(String databaseId) {
        SqlSessionFactoryBean factoryBean;
       boolean isExist =  context.containsBean(databaseId);
       if(isExist) {
           factoryBean= (SqlSessionFactoryBean) context.getBean(databaseId);
       }
       return  null;
    }
}
