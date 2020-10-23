package com.zzz.hathor.codemaker.config;

import com.zaxxer.hikari.HikariDataSource;
import com.zzz.hathor.codemaker.CodemakerApplication;
import com.zzz.hathor.codemaker.domain.config.DataSourceProperty;
import com.zzz.hathor.codemaker.domain.vo.query.ProjectGennerInfo;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * @ClassName MybatisConfig
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/10 11:00
 * @Version 1.0.0
 **/
@Configuration
public class MybatisConfig {
    @Autowired
    ProjectGennerInfo projectGennerInfo;

    /**
     * 实例化DataSource
     * @return
     * @throws SQLException
     */
    @Bean("hikarysource")
    public DataSource createDataSource( DataSourceProperty dataSourceProperty) throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setLoginTimeout(60);
        dataSource.setMaximumPoolSize(8);
        dataSource.setMinimumIdle(1);

        String userName = dataSourceProperty.getUsername();
        if(!StringUtils.isEmpty(userName)) {
            dataSource.setUsername(userName);
        }
        String pwd = dataSourceProperty.getPassword();
        if(!StringUtils.isEmpty(pwd)) {
            dataSource.setPassword(pwd);
        }

        dataSource.setDriverClassName(dataSourceProperty.getDrivername());
        dataSource.setJdbcUrl(dataSourceProperty.getUrl());
        return dataSource;
    }
    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean createSqlSessionFactoryBean(@Qualifier("hikarysource") DataSource dataSource) throws SQLException, IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        String locationPattern = "classpath*:/com/zzz/hathor/codemaker/mapper/*-Mapper.xml";
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(new PathMatchingResourcePatternResolver());
        Resource[] resources = resolver.getResources(locationPattern);
        sqlSessionFactoryBean.setMapperLocations(resources);
        return  sqlSessionFactoryBean;
    }
   @Bean("MapperScannerConfigurer")
    public MapperScannerConfigurer createMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.zzz.hathor.base.codemaker.mapper");
        return  configurer;
    }
    @Bean("DataSourceTransactionManager")
    public DataSourceTransactionManager createDataSourceTransactionManager(@Qualifier("hikarysource") DataSource dataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return  manager;
    }
}
