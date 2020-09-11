package com.zzz.hathor.codemaker.util;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @ClassName SpringSqlSessionFactoryBuilder
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/10 18:36
 * @Version 1.0.0
 **/
public class SpringSqlSessionFactoryRefresher {
   private BeanDefinitionRegistry registry;

   public SpringSqlSessionFactoryRefresher(ApplicationContext  context) {
      this.registry= (BeanDefinitionRegistry) context;

   }

   public void refresh(String beanName , SqlSessionFactoryBean sqlSessionFactoryBean) {

      BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(SqlSessionFactoryBean.class);
      BeanDefinition definition = definitionBuilder.getBeanDefinition();
      definition.setBeanClassName(SqlSessionFactoryBean.class.getName());
      definition.setLazyInit(false);
      definition.setScope(BeanScope.SCOPE_PROTOTYPE.scope);
      HashMap<String,Object> attributs=getAttributes(sqlSessionFactoryBean);
      attributs.entrySet().forEach(stringObjectEntry -> {
         definition.setAttribute(stringObjectEntry.getKey(),stringObjectEntry.getValue());
      });
       registry.registerBeanDefinition(beanName,definition);

   }

   /**
    * 获取所有属性值
    * @param sqlSessionFactoryBean
    * @return
    */
   private  static  HashMap<String,Object> getAttributes(final SqlSessionFactoryBean sqlSessionFactoryBean) {
      Field[] fields =  sqlSessionFactoryBean.getClass().getDeclaredFields();
       HashMap<String,Object> attributs = (HashMap<String, Object>) Arrays.asList(fields).stream().filter(field -> {field.setAccessible(true);
            boolean isFinal = Modifier.isFinal(field.getModifiers());
               Object value=null;
               try {
                   value= field.get(sqlSessionFactoryBean);
               } catch (IllegalAccessException e) {
                  e.printStackTrace();
               }
               return (!isFinal) && (value!=null);
            }).collect(Collectors.toMap(Field::getName,field -> {
           try {
              return field.get(sqlSessionFactoryBean);
           } catch (IllegalAccessException e) {
              e.printStackTrace();
           }
           return null;
        }));
      return  attributs;
   }

   enum BeanScope{
       SCOPE_SINGLETON ("singleton"),
       SCOPE_PROTOTYPE ("prototype");
       private  String scope ;

      BeanScope(String scope) {
         this.scope = scope;
      }
   }
}
