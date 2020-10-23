package com.zzz.hathor.codemaker.domain.vo.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName ProjectGennerInfo
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/9 15:21
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ProjectGennerInfo {
    @NotBlank
    @Value("${code.maker.project.name}")
    private String projectname ;
    private String desc ;
    private String author;
    private boolean permitlombok;

    private ControllerInfo controller;
    private ServiceInfo service;
    private DaoInfo dao ;
    private  DomainInfo domain;



}
