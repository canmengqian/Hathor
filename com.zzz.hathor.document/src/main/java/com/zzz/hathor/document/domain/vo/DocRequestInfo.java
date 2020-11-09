package com.zzz.hathor.document.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class DocRequestInfo extends  BaseRequestInfo{
    private Integer id;
    private String docTitle ;
    private Date gmt_create ;
    private Date gmt_modified;
}
