package com.zzz.hathor.document.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value="recorder_doc",keepGlobalPrefix = false, autoResultMap=true)
public class DocEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value="doc_title")
    private String docTitle ;
    @TableField(value="gmt_create")
    private Date gmt_create ;
    @TableField(value="gmt_modified")
    private Date gmt_modified;
    @TableLogic(value = "0",delval = "1")
    private  Boolean is_delete  ;



}
