package com.zzz.hathor.codemaker.domain.vo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName RepositoryModel
 * @Description
 * @Author 25703
 * @Date 2020/9/10 10:35
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class RepositoryModel {
    private String userName;
    private String vender;
    private String schema;
    private List<TableModel> tables;
}
