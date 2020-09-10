package com.zzz.hathor.codemaker.domain.entity.sqlite;

import lombok.*;
import org.springframework.stereotype.Component;

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
public class TableInfo {
    private String tableName;
    private String sql;
}
