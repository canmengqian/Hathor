package com.zzz.hathor.base.codemaker.domain.vo.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName DomainInfo
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/9 16:13
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DomainInfo {
    private  boolean mustgenner;
    private String domainsuffix ;
    private String domainpck;
    private String[] subDomain;
}
