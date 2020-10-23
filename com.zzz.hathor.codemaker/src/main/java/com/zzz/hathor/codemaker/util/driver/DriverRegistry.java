package com.zzz.hathor.codemaker.util.driver;

import org.sqlite.JDBC;

import java.util.HashMap;

/**
 * @ClassName DriverRegistry
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/11 15:44
 * @Version 1.0.0
 **/
public class DriverRegistry {
    private static HashMap<String,Class<?>> drivers = new HashMap<>(8);

    static {
        drivers.put("SQLITE", JDBC.class);
    }

    public static Class<?> getDriverClass (String vender) {
       return drivers.get(vender.toUpperCase());
    }

    public static String getDriverName (String vender) {
        return drivers.get(vender.toUpperCase()).getName();
    }

}
