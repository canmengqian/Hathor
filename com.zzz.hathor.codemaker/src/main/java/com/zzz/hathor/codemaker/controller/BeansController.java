package com.zzz.hathor.codemaker.controller;

import com.zzz.hathor.base.web.http.BaseResponseBody;
import com.zzz.hathor.base.web.http.SimpleResponseHandler;
import com.zzz.hathor.codemaker.domain.vo.query.ProjectGennerInfo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.FactoryBeanRegistrySupport;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName BeansController
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/9 10:24
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("bean")
public class BeansController {
    @Resource
    ApplicationContext context;

    @Resource
    BeanFactory beanFactory;
    @Autowired
   ProjectGennerInfo ProjectGennerInfo;
    @GetMapping(value = "/query/all")
    public BaseResponseBody<List<String>> queryBeans() {
     return   SimpleResponseHandler.success(HttpStatus.OK,Arrays.asList(context.getBeanDefinitionNames()));
    }
    @PutMapping(value = "/refresh/{name}")
    public BaseResponseBody refreshBean(@PathVariable(value = "name") final String beanName) {

        DefaultListableBeanFactory listableBeanFactory  = (DefaultListableBeanFactory) beanFactory;
        boolean singleBean = listableBeanFactory.containsBeanDefinition(beanName) ;
        if(singleBean) {
            BeanDefinition definition = listableBeanFactory.getBeanDefinition(beanName);
            listableBeanFactory.registerBeanDefinition(beanName,definition);// 重新注册
        }

        return  SimpleResponseHandler.success(HttpStatus.OK,"OK");
    }
   /* @PutMapping(value = "/refresh/all")
    public BaseResponseBody refreshAll() {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        ((AbstractRefreshableApplicationContext) context).refresh();
    }*/
}
