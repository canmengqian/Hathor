package com.zzz.hathor.codemaker.util.executor;

import com.zzz.hathor.codemaker.util.registry.SqlSessionFactoryInfo;
import com.zzz.hathor.codemaker.util.registry.SqlSessionFactoryRegistry;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.stream.Collectors;

public class SimplerMapperExecutor<T,R> implements  MapperExecutor {

    private T target;

    private SqlSessionFactoryInfo sqlSessionFactoryInfo;

    private SqlSession sqlSession;

    private  String link ;

    public SimplerMapperExecutor(String link) {
        this.link = link;
    }

    @Override
    public List<R> execut(Object... objs) throws Exception {

        List<R> resultDatas =null;
        try {
            if (openSession(link) != null) {
                target = (T) this.sqlSession.getMapper(Class.class);
                resultDatas = queryInvoke(objs);
            }
            this.sqlSession.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.sqlSession.close();
            this.sqlSession = null;
            this.target = null;
        }
        return resultDatas;
    }

    private SqlSession openSession (String name) throws Exception {
        SqlSessionFactoryInfo sqlSessionFactoryInfo = SqlSessionFactoryRegistry.getFactory(name);
        SqlSessionFactoryBean sqlSessionFactoryBean = sqlSessionFactoryInfo.getSqlSessionFactoryBean();
        SqlSession sqlSession = sqlSessionFactoryBean.getObject().openSession();
        this.sqlSession = sqlSession;
        return  this.sqlSession;
    }


    private List<R> queryInvoke(Object... objs) throws TooManyListenersException {
       List<Method> methods = Arrays.asList(target.getClass().getMethods()).stream().filter(m-> Modifier.isPublic(m.getModifiers()) && m.getName().equals("")).collect(Collectors.toList());
       if(methods.size()==1) {
           try {
              return (List<R>) methods.get(0).invoke(target,objs);
           } catch (IllegalAccessException | InvocationTargetException  e) {
               e.printStackTrace();
           }
       }else {
           throw  new TooManyListenersException();
       }
       return null;
    }
}
