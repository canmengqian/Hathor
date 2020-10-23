package com.zzz.hathor.codemaker;

import com.zzz.hathor.codemaker.domain.config.DataSourceProperty;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties(value = {DataSourceProperty.class})
@ComponentScan("com")
@MapperScan(basePackages = {"com.zzz.hathor.codemaker.mapper"})
public class CodemakerApplication {

    public static void main(String[] args) {

        SpringApplication.run(CodemakerApplication.class, args);
    }

}
