package com.zzz.hathor.codemaker.service;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;

/**
 * @ClassName SqlSessionJudgeService
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/10 17:21
 * @Version 1.0.0
 **/
public interface SqlSessionJudgeService {
    SqlSessionFactoryBean createSqlSessionFactoryBean(String databaseId);
}
