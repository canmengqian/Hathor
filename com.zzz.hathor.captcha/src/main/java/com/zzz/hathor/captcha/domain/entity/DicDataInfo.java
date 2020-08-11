package com.zzz.hathor.captcha.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 *字典表
 */
@Data
@TableName(value = "dic_data_info",keepGlobalPrefix=false)
public class DicDataInfo extends BaseInfo {

    @TableId(type = IdType.AUTO)
    private String id ;
    @TableField
    private String key ;
    @TableField
    private String value ;
    @TableField
    private String clazzName;
    @TableField
    private String desc ;
    @TableField
    private Data createTime ;
    @TableField
    private Boolean deprecated;
    @TableLogic(value = "0" ,delval = "1")
    private Boolean isDelete ;



}
