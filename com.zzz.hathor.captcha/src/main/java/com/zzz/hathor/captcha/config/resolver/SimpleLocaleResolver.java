package com.zzz.hathor.captcha.config.resolver;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 基于Session的
 * @See 国际化解析器 SpringBoot日记——国际化篇 https://www.cnblogs.com/iceb/p/9225678.html
 */
public class SimpleLocaleResolver implements LocaleResolver {
    // defaut language
    private final static  String DEFAULT_LANGUAGE = "zh";

    // default country
    private final static  String DEFAULT_COUNTRY = "CN";


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
       String lang =  httpServletRequest.getParameter("lang");
        Locale locale = null;
        if(StringUtils.isEmpty(lang))    {
            locale = new Locale(DEFAULT_LANGUAGE,DEFAULT_COUNTRY);
        }else {
            String[] langArr = lang.split("_");
            locale = new Locale(langArr[0],langArr[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
