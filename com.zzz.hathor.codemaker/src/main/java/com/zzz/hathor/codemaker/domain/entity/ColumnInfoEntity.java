package com.zzz.hathor.codemaker.domain.entity;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName ColumnInfoEntity
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/11 17:37
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@ToString
public class ColumnInfoEntity {
    private String primaryKey;
    private String colName ;
    private String colType ;
    private String colComment;
    private Object defaultName;
    private boolean isAutoincrement;
}
