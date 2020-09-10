package com.zzz.hathor.codemaker.domain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ArchitectureProperty
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/9 14:55
 * @Version 1.0.0
 **/
@ConfigurationProperties(prefix="code.maker.architec")
@Component
public class ArchitectureProperty {
    private String servicesuffix ;
    private String controllersuffix;
    private String daosuffix;
    private OrmType ormType = OrmType.MYBATISPLUS;

    private String servicepck;
    private String controllerpck;
    private String domainpck;
    private String[] domainmapping = {"entity","dto","vo","query"};

    public ArchitectureProperty() {
    }

    public String getServicesuffix() {
        return servicesuffix;
    }

    public void setServicesuffix(String servicesuffix) {

        this.servicesuffix = servicesuffix;
    }

    public String getControllersuffix() {
        return controllersuffix;
    }

    public void setControllersuffix(String controllersuffix) {
        this.controllersuffix = controllersuffix;
    }

    public String getDaosuffix() {
        return daosuffix;
    }

    public void setDaosuffix(String daosuffix) {
        this.daosuffix = daosuffix;
    }

    public String getServicepck() {
        return servicepck;
    }

    public void setServicepck(String servicepck) {
        this.servicepck = servicepck;
    }

    public String getControllerpck() {
        return controllerpck;
    }

    public void setControllerpck(String controllerpck) {
        this.controllerpck = controllerpck;
    }

    public String getDomainpck() {
        return domainpck;
    }

    public void setDomainpck(String domainpck) {
        this.domainpck = domainpck;
    }

    public String[] getDomainmapping() {
        return domainmapping;
    }

    public void setDomainmapping(String[] domainmapping) {
        this.domainmapping = domainmapping;
    }

    public OrmType getOrmType() {
        return ormType;
    }

    public void setOrmType(OrmType ormType) {
        this.ormType = ormType;
    }
}
