package com.zzz.hathor.codemaker.util;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SpringSqlSessionFactoryRegistry
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/10 17:36
 * @Version 1.0.0
 **/
public class SpringSqlSessionFactoryRegistry {
    private static ConcurrentHashMap<String, SqlSessionFactoryBean> sqlSessionFactoryBeans = new ConcurrentHashMap<>(2);



}
