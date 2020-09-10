package com.zzz.hathor.base.codemaker.domain.vo.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ControllerInfo
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/9 16:09
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ControllerInfo {
    private String  controllersuffix ;
    private String controllerpck;
    private  boolean mustgenner;
}
