package com.zzz.hathor.codemaker.util.executor;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * @ClassName SpringSqlSessionFacoryNamesCache
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/11 11:28
 * @Version 1.0.0
 **/
public class SpringSqlSessionFacoryNamesCache {
    private final static int INIT_SIZE = 0;
    private static int maxSize = 10;
    private static Queue factoryBeanIds =new LinkedList();

    ListableBeanFactory beanFactory;

    private static boolean isOverCapacity() {
       return factoryBeanIds.size() > maxSize;
    }

    public static void addName(String name) {
        if(isOverCapacity()) {
            factoryBeanIds.poll();
        }
        factoryBeanIds.add(name);
    }

    public static  String removeNmae(String name ) {
       return (String) factoryBeanIds.poll();
    }

    public static List<Object> getAllName() {
        return Arrays.asList(factoryBeanIds.toArray());
    }
}
