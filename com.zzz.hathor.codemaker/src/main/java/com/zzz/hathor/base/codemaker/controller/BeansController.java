package com.zzz.hathor.base.codemaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    @RequestMapping(value = "/query")
    public List<String> queryBeans() {
        return Arrays.asList(context.getBeanDefinitionNames());
    }
}
