package com.zzz.hathor.base.codemaker;

import com.zzz.hathor.base.codemaker.domain.config.DataSourceProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties(value = {DataSourceProperty.class})
@ComponentScan("com")
public class CodemakerApplication {

    public static void main(String[] args) {

        SpringApplication.run(CodemakerApplication.class, args);
    }

}
