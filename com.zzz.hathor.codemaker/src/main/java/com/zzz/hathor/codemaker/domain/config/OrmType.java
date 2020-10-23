package com.zzz.hathor.codemaker.domain.config;

public enum OrmType {
    MYBATIS("mybatis"),
    MYBATISPLUS("mybatis-plus"),
   JPA("jpa");

    private String type ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    OrmType(String type) {
        this.type = type;
    }
}
