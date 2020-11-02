package com.zzz.hathor.codemaker.util.registry;

import org.mybatis.spring.SqlSessionFactoryBean;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MapperRegistry
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/11 18:11
 * @Version 1.0.0
 **/
public class SqlSessionFactoryRegistry {
    private volatile  static ConcurrentHashMap<String,SqlSessionFactoryInfo> factorys = new ConcurrentHashMap<String,SqlSessionFactoryInfo>(16,0.75f);
    public static SqlSessionFactoryInfo  getFactory(String beanName) {
        return factorys.get(beanName);
    }
    public static SqlSessionFactoryInfo  getFactory(String beanName, SqlSessionFactoryInfo sqlSessionFactoryInfo) {
        return factorys.put(beanName,sqlSessionFactoryInfo);
    }

}
