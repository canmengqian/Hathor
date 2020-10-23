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
    private String schema;
    private String tableName;
    private String tableComment;
    private List<ColumnInfoEntity> cols;
    private String sql;
}
