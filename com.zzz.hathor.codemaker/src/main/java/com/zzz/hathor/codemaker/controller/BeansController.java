package com.zzz.hathor.codemaker.controller;

import com.zzz.hathor.base.web.http.BaseResponseBody;
import com.zzz.hathor.base.web.http.SimpleResponseHandler;
import com.zzz.hathor.codemaker.domain.vo.query.DataSourceInfoQuery;
import com.zzz.hathor.codemaker.service.SpringSqlSessionFactoryBeanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BeansController
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/9 10:24
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("bean")
@Api(protocols = "http" ,value = "刷新sessionFactoryBean")
public class BeansController {
    @Resource
    ApplicationContext context;

    @Autowired
    SpringSqlSessionFactoryBeanService factoryBeanService;

    @ApiOperation(value = "查询Bean对象", notes = "", httpMethod = "GET")
    @GetMapping(value = "/query")
    public BaseResponseBody queryBeans(@RequestParam(value = "type",required = false)String type ,@RequestParam(value = "name",required = false)String name   ) throws ClassNotFoundException {
        List<String> params =Arrays.asList(new String[]{type,name}).stream().filter(e->e!=null).collect(Collectors.toList());
        List<String> beanNames =  Arrays.asList(context.getBeanDefinitionNames());
       return SimpleResponseHandler.success("200","查询成功",beanNames);
    }

    @ApiOperation(value = "刷新sessionFactory")
    @PostMapping(value = "/refresh")
    public BaseResponseBody refreshSqlSessionFactory(@RequestParam(value = "foceRefresh") Boolean foce,  DataSourceInfoQuery dataSourceInfoQuery) throws IOException {
      /* String beanName =  factoryBeanService.assemberSqlSessionFactoryBean(dataSourceInfoQuery);*/
        return SimpleResponseHandler.success("200","查询成功","");
    }

}
