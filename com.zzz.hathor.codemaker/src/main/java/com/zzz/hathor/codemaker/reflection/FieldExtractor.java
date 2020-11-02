package com.zzz.hathor.codemaker.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;

/**
 * 字段提取器
 */
public class FieldExtractor {
    public static HashMap<String ,Object>extractFields(Object object, String... filedNames) throws NoSuchFieldException, IllegalAccessException {

       if(filedNames==null || filedNames.length == 0) {
           return null;
       }
       Class clazz  = object.getClass();
       HashMap<String,Object> values = new HashMap<>();
       for(String filedName : filedNames) {
           Field field = clazz.getField(filedName);
           if(isCanbeModify(field)) {
               throw  new IllegalAccessException();
           }
           values.put(filedName,field.get(object));
       }
       return  values;
    }


    private static Boolean isCanbeModify(Field field) {
        field.setAccessible(true);
        return  Modifier.isFinal(field.getModifiers());
    }
}
