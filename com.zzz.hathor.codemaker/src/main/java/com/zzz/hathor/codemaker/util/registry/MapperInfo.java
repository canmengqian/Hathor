package com.zzz.hathor.codemaker.util.registry;

import com.zzz.hathor.codemaker.domain.config.ProviderVenderEnum;

/**
 * @ClassName MapperInfo
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/11 18:11
 * @Version 1.0.0
 **/
public class MapperInfo {
    private String sqlSessionFactoryBeanName;
    private static final String DEFAULT_MAPPER_CLASSNAME_PREFIX = "com.zzz.hathor.codemaker.mapper";
    private  ProviderVenderEnum vender;
}
