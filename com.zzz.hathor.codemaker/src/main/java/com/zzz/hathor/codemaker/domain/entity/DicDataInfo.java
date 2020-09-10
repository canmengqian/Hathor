package com.zzz.hathor.codemaker.domain.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName DicDataInfo
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/10 11:32
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@ToString
public class DicDataInfo {
    private String id ;
    private String key ;
    private String value ;
    private String clazzName;
    private String desc ;
    private Boolean deprecated;
    private Date createTime ;
    private Date updateTime;
    private Boolean isDelete ;
}
