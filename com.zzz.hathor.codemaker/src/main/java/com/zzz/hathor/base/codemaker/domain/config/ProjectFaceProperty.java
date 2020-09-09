package com.zzz.hathor.base.codemaker.domain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProjectFaceInfo
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/9 15:24
 * @Version 1.0.0
 **/
@ConfigurationProperties(prefix="code.maker.project")
@Component
public class ProjectFaceProperty {
    private  String name ;  // 项目名
    private  String desc ;  //项目描述
    private  String author ; //作者
    private  String modulename ; //包路径
    private  boolean permitlombok = false;

    public boolean isPermitlombok() {
        return permitlombok;
    }

    public void setPermitlombok(boolean permitlombok) {
        this.permitlombok = permitlombok;
    }

    public ProjectFaceProperty() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }
}
