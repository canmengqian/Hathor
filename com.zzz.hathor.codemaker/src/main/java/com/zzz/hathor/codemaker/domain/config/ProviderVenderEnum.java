package com.zzz.hathor.codemaker.domain.config;

public enum ProviderVenderEnum {
    SQLITE("SQLITE"),
    MYSQL("MYSQL"),
    ORACLE("ORACLE"),
    H2("H2");
    public String vender;

    ProviderVenderEnum(String vender) {
        this.vender = vender;
    }

    public String getVender() {
        return vender;
    }

    public void setVender(String vender) {
        this.vender = vender;
    }
}
