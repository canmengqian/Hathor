package com.zzz.hathor.cache.config;

import java.beans.BeanInfo;
import java.beans.PropertyEditor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zzz.hathor.cache.util.anotation.ExpireType;
import com.zzz.hathor.cache.util.anotation.SimpleCache;
import com.zzz.hathor.cache.util.cache.SchedulerCache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.format.Formatter;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;
import org.springframework.transaction.interceptor.TransactionalProxy;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.validation.Errors;


@Aspect //AOP 切面
@Component
public class SimpleCacheAspect {
	/*通过@Pointcut指定切入点 ，这里指定的切入点为LogAnnotation注解类型，也就是
    被@LogAnnotation注解修饰的方法，进入该切入点*/
 
  @Pointcut("@annotation(com.zzz.hathor.cache.util.anotation.SimpleCache)")
  private void pointcut() {
	 // 	System.out.println("进入连接点");
  }

  @Before(value = "pointcut() && @annotation(cache)")
  public Object before(ProceedingJoinPoint point, SimpleCache cache) {
		//System.out.println("进入连接点");
	 Object[] objs =  point.getArgs();
	return objs;
	  
  }
  

  /**
   * 方法执行后
   *
   * @param joinPoint
   * @param
   * @param result
   * @return
   */
  @AfterReturning(value = "pointcut() && @annotation(cache)", returning = "result")
  public Object afterReturning(JoinPoint joinPoint, SimpleCache cache, Object result) {
      //System.out.println("执行了afterReturning方法: result=" + result);
	  //AJAXUtil.success(response, msg);
    //  ResourceLoader
     // BeanFactoryAware
     // BeanPostProcessor
      //BeanPostProcessor
     // InitializingBean
    //  DisposableBean
     // BeanDefinition
     // BeanDefinitionCustomizer
   //   BeanDefinitionParser
      //BeanDefinitionHolder
      //BeanDefinitionVisitor
      //BeanDefinitionReader
      //BeanDefinitionBuilder
      //BeanDefinitionRegistry
      // BeanWrapper
    //  PropertyEditor
      //PropertyEditorRegistry
      //PropertyEditorRegistrar
      //BeanInfo
     // PropertyPlaceholderConfigurer
	  //TransactionDefinition
	 // TransactionSynchronizationManager
	  //TransactionalEventListener
	 // TransactionProxyFactoryBean
	//  DataSourceUtils

      return Void.class;
  }

  @Around(value = "pointcut() &&  @annotation(cache)")
  public Object around(ProceedingJoinPoint point, SimpleCache cache) {
	  System.out.println("进入切面");
	  HashMap<String,Object> paramValue  = resolveMethodParam(point);
	  Object result = null;
	  String key = cache.key();
	  boolean is_exist_key =false;
	  if(key!=null || key.trim()!="") {
		  evictKey(cache);
		  is_exist_key = SchedulerCache.getCache().isExist(key);
		
		if(is_exist_key) {
			result = SchedulerCache.getCache().get(key);
		}
	  }
	  if(result == null ) {
		 result =  syncWithCache(result, cache);
	  }
	  //AJAXUtil.success((HttpServletResponse) paramValue.get("response"), (Collection<? extends ValueObject>)result);
	  return Void.class;
  }

  public Object syncWithCache(Object result, SimpleCache cache) {
	 Object bean =  new AnnotationConfigApplicationContext().getBean(cache.resources().repository());
	 Object rs = null;
	try {
		rs=bean.getClass().getDeclaredMethod(cache.resources().method(), null).invoke(bean, null);
		if (rs!= null ) {
			SchedulerCache.getCache().put(cache.key(),rs);
		}
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
  }
  /**
   * 方法执行后 并抛出异常
   *
   * @param joinPoint
   * @param
   * @param ex
   */
  @AfterThrowing(value = "pointcut() && @annotation(cache)", throwing = "ex")
  public void afterThrowing(JoinPoint joinPoint, SimpleCache cache, Exception ex) {
      ex.printStackTrace();
      HttpServletResponse response = (HttpServletResponse) joinPoint.getArgs()[1];
      //AJAXUtil.failure(response,"系统错误，请联系管理员！");
  }

  
  public HashMap<String,Object> resolveMethodParam(JoinPoint joinPoint) {
	  HashMap<String, Object> paramMap = new HashMap<>(2);
	  Object[] paramValues = joinPoint.getArgs();
	  Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
	  method.getParameterTypes();
	  Parameter[] params = method.getParameters();
	  for(int i = 0 ;i < params.length;i++) {
		  String name = params[i].getName();
		  Class<?> type =  params[i].getType();
		  
		  if(type.equals(HttpServletRequest.class)) {
			  paramMap.put("request", paramValues[i]);
			  break;
		  }
		  if(type.equals(HttpServletResponse.class)) {
			  paramMap.put("response", paramValues[i]);
			  break;
		  }
		  paramMap.put(name,paramValues[i]);
	  }
	return paramMap;
	  
  }
  
  public void evictKey(SimpleCache cache) {
	  SchedulerCache<String, Object> cacheComp= SchedulerCache.getCache();
	  ExpireType type = cache.policy();
	  switch (type.getType()) {
		case "TIME":
			cacheComp.evict(cache.key(), cache.expireTime(), cache.unit());
			break;

		default:
			break;
	}
  }

	public static void main(String[] args) {

			String s1 ="abc";
			String s2 = s1;
			String s5 ="abc";
			String s3 = new String("abc");
			String s4 = new String("abc1");
			System.out.println("== comparison : " + (s1 == s5));
			System.out.println("== comparison : " + (s1 == s2));
			System.out.println("Using equals method : " + s1.equals(s2));
			System.out.println("== comparison : " + s3 == s4);
			System.out.println("Using equals method : " + s3.equals(s4));
		Integer
	}
}
