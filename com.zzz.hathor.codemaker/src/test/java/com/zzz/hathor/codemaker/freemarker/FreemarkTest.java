package com.zzz.hathor.codemaker.freemarker;

import com.zzz.hathor.codemaker.CodemakerApplication;
import freemarker.cache.StrongCacheStorage;
import freemarker.cache.TemplateLookupStrategy;
import freemarker.core.PlainTextOutputFormat;
import freemarker.template.*;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;

public class FreemarkTest {
    @Test
    public void testFreeMark() throws IOException, TemplateException {
       Configuration configuration = new Configuration();
       configuration.setTemplateLookupStrategy(TemplateLookupStrategy.DEFAULT_2_3_0);// 设置发现策略
        //TemplateHashModelEx modelEx = new
        //configuration.setAllSharedVariables();
       configuration.setAttemptExceptionReporter(AttemptExceptionReporter.LOG_ERROR_REPORTER);
        configuration.setAutoEscapingPolicy(22); //自动去空白
        configuration.setCacheStorage(new StrongCacheStorage());//缓存策略
        configuration.setClassForTemplateLoading(CodemakerApplication.class,"/freemarker");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setOutputFormat(PlainTextOutputFormat.INSTANCE);
        configuration.setLogTemplateExceptions(true);
        //configuration.setSetting();
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);// 异常处理器
        configuration.setSharedVariable("name","zhangsan");
        Template template = configuration.getTemplate("Hello.ftl");
        template.setAutoFlush(true);
        Writer out = new OutputStreamWriter(System.out);
        HashMap<String,Object> model = new HashMap<>();
        model.put("age",25);
        template.process(model,out);
    }
}
