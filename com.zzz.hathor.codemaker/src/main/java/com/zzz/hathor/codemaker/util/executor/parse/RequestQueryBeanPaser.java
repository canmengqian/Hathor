package com.zzz.hathor.codemaker.util.executor.parse;

import com.zzz.hathor.codemaker.domain.vo.query.DataSourceInfoQuery;
import com.zzz.hathor.codemaker.reflection.FieldExtractor;
import com.zzz.hathor.codemaker.util.StringUtil;
import org.springframework.util.StringUtils;

import java.util.HashMap;

public class RequestQueryBeanPaser {
    private final static String[] assembleFields = {"username","password","vender","url"};
    public static String parseBean(DataSourceInfoQuery query) {
        String parserStr ="";
        try{
           HashMap<String, Object> fieldsMap=FieldExtractor.extractFields(query,assembleFields);
           parserStr = new StringUtil<String,Object>().extract(fieldsMap);
        }catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(parserStr)) {
            //TODO
        }
        return  parserStr;
    }
}
