package com.zzz.hathor.codemaker.domain.vo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @ClassName TableModel
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/10 10:37
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class TableModel {
    private String tableName;
    private  String tableComment ;
}
