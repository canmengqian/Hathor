package com.zzz.hathor.codemaker.controller;

import com.zzz.hathor.base.web.http.BaseResponseBody;
import com.zzz.hathor.codemaker.domain.vo.model.TableModel;
import com.zzz.hathor.codemaker.domain.vo.query.DataSourceInfoQuery;
import com.zzz.hathor.codemaker.util.SpringSqlSessionFactoryRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TableInfoController
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/10 17:08
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("table")
public class TableInfoController {

    @Autowired
    ApplicationContext context;
    @GetMapping("/query/info")
    public BaseResponseBody<List<TableModel>> queryTable(final DataSourceInfoQuery dataSourceInfoQuery) throws Exception {
       // SpringSqlSessionFactoryRegistry.addSqlSessionFactoryBean((AbstractRefreshableApplicationContext) context,"bean1",new SqlSessionFactoryBean());
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context;
        BeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(SqlSessionFactoryBean.class);
        BeanDefinitionBuilder builder =  BeanDefinitionBuilder.genericBeanDefinition(SqlSessionFactoryBean.class);
        beanDefinition=builder.getBeanDefinition();
        registry.registerBeanDefinition("bean1",beanDefinition);
        context.getBean("bean1");
        return null;
    }
}
