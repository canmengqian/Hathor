package com.zzz.hathor.captcha.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *字典表
 */
@Data
public class DicDataInfo extends BaseInfo {

    private String id ;
    private String key ;
    private String value ;
    private String desc ;
    private Data createTime ;
    private Boolean deprecated;


}
