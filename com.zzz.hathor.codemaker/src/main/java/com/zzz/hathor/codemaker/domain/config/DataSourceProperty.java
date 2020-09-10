package com.zzz.hathor.codemaker.domain.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName DataSourceProerty
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/9 13:38
 * @Version 1.0.0
 **/
@ConfigurationProperties(prefix="code.maker.datasource")
@Component
public class DataSourceProperty {
    private  String drivername ;
    private  String url;
    private String username ;
    private String password ;

    public DataSourceProperty(String drivername, String url, String username, String password) {
        this.drivername = drivername;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public DataSourceProperty() {
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
