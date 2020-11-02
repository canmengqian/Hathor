package com.example.demo.Cache;

import io.netty.util.internal.StringUtil;
import org.springframework.cache.caffeine.CaffeineCache;

/**
 * @ClassName CaffineCacheTest
 * @Description TODO
 * @Author 25703
 * @Date 2020/8/25 9:54
 * @Version 1.0.0
 **/
public class CaffineCacheTest {
    public static String formatVal(String str , int number) {
        /*if(StringUtil.isEmpty(str)) {
            return str ;
        }*/
        boolean is_first_subcrision = str.startsWith("-.");
        if (is_first_subcrision) {
            str = "-0."+str.substring(2);
        }
        boolean is_first_point = str.startsWith(".");
        if (is_first_point) {
            str = "0"+str;
        }

        String[] number_parts = str.split("\\.");
        if(number_parts.length == 1) {
            str+=".";
            for ( int i =0;i<number;i++) {
                str+="0";
            }
        }else {
            int secend_length = number_parts[1].length();
            int remain_length = number-secend_length;
            if(number_parts.length == 2) {
                for ( int i =0;i<remain_length;i++) {
                    str+="0";
                }
            }
        }
        return str ;
    }
    public static void main(String[] args) {

        String rs = formatVal("0.99",6);
        System.out.println(rs);
        rs = formatVal("0",6);
        System.out.println(rs);
        rs = formatVal(".99",6);
        System.out.println(rs);

        rs = formatVal(".99",2);
        System.out.println(rs);
        rs = formatVal("-.990000",2);
        System.out.println(rs);
    }
}
