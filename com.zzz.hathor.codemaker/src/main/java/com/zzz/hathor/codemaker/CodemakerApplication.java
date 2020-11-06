package com.zzz.hathor.codemaker;

import com.zzz.hathor.codemaker.domain.config.DataSourceProperty;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties(value = {DataSourceProperty.class})
@ComponentScan("com")
@MapperScan(basePackages = {"com.zzz.hathor.codemaker.mapper"})
@EnableEurekaClient
@LoadBalancerClient
public class CodemakerApplication {

    public static void main(String[] args) {

        SpringApplication.run(CodemakerApplication.class, args);
    }

}
