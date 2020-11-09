package com.zzz.hathor.document.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value="doc_relevance",keepGlobalPrefix = false, autoResultMap=true)
@Builder
public class DocRelevanceEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "doc_id")
    private  String docId ;
    @TableField(value = "source_id")
    private  String sourceId ;
    @TableField(value = "link_title")
    private  String  linkTitle;
    @TableField(value = "url")
    private String url ;
    @TableField(value = "gmt_create")
    private Date gmtCreate ;
    @TableField(value="gmt_modified")
    private Date gmtModified;
    @TableLogic(value = "0",delval = "1")
    private  Boolean is_delete  ;
}
