package com.zzz.hathor.captcha.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 *字典表
 */
@Data
@ToString
@TableName(value = "dic_data_info")
public class DicDataInfo {

    @TableId(type = IdType.AUTO)
    private String id ;
    @TableField
    private String key ;
    @TableField
    private String value ;
    @TableField(value = "clazzName")
    private String clazzName;
    @TableField
    private String desc ;
    @TableField
    private Boolean deprecated;
    @TableField(value = "createTime")
    private Date createTime ;
    @TableField(value = "updateTime")
    private Date updateTime;


    @TableLogic(value = "0" ,delval = "1")
    private Boolean isDelete ;



}
