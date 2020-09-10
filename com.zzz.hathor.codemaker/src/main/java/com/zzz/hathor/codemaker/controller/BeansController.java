package com.zzz.hathor.codemaker.controller;

import com.zzz.hathor.codemaker.domain.vo.query.ProjectGennerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Autowired
   ProjectGennerInfo ProjectGennerInfo;
    @RequestMapping(value = "/query")
    public ProjectGennerInfo queryBeans(final ProjectGennerInfo request) {
        ProjectGennerInfo = request;
        return ProjectGennerInfo;
    }

}
