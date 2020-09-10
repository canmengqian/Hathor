package com.zzz.hathor.codemaker.domain.vo.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName DataSourceInfo
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/9 15:53
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataSourceInfo {
    private  String drivername ;
    private  String url;
    private String username ;
    private String password ;

    private List<String> tables;
}
