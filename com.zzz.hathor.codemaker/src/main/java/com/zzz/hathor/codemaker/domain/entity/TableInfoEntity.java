package com.zzz.hathor.codemaker.domain.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName TableInfo
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/10 16:56
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@ToString
public class TableInfoEntity {
    private String schemaName;
    private String tableName;
    private String tableComment;
    private String colName ;
    private String colComment;
    private String colPosition;
    private String colDefault;
    private String isNull;
    private String colType;
    private String maxLength;
    private String numPrecision;
    private String numScala;
    private String primaryKey;
    private String extraComment;
    private String sql;
}
