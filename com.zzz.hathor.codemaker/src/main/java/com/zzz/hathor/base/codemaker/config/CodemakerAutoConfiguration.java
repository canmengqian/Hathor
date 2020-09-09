package com.zzz.hathor.base.codemaker.config;

import com.zzz.hathor.base.codemaker.domain.config.ArchitectureProperty;
import com.zzz.hathor.base.codemaker.domain.config.DataSourceProperty;
import com.zzz.hathor.base.codemaker.domain.config.ProjectFaceProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName CodemakerAutoConfiguration
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/9 14:06
 * @Version 1.0.0
 **/
@Configuration
@ConditionalOnClass({DataSourceProperty.class, ArchitectureProperty.class})
@EnableConfigurationProperties({DataSourceProperty.class,ArchitectureProperty.class, ProjectFaceProperty.class})
public class CodemakerAutoConfiguration {
}
