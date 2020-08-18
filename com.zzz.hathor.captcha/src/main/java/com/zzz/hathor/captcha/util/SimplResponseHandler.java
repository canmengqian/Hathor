package com.zzz.hathor.captcha.util;

import com.zzz.hathor.captcha.domain.entity.BaseResponseBody;

/**
 * @ClassName SimplResponseHandler
 * @Description TODO
 * @Author 25703
 * @Date 2020/8/18 17:55
 * @Version 1.0.0
 **/
public class SimplResponseHandler<T> {
   public  BaseResponseBody fail(String code ,String msg) {
       BaseResponseBody body = BaseResponseBody.builder().code(code).message(msg).build();
       return body;
   }

   public  BaseResponseBody fail(String code ,String msg , T t) {
       BaseResponseBody body = BaseResponseBody.builder().code(code).message(msg).t(t).build();
       return  body;
   }


    public  BaseResponseBody fail(String code ,String msg ,Throwable throwable) {
        BaseResponseBody body = BaseResponseBody.builder().code(code).message(msg).t(throwable.getMessage()).build();
        return  body;
    }

    public BaseResponseBody success(String code ,String msg) {
        BaseResponseBody body = BaseResponseBody.builder().code(code).message(msg).build();
        return body;
    }

    public BaseResponseBody success(String code ,String msg,T t) {
        BaseResponseBody body = BaseResponseBody.builder().code(code).message(msg).t(t).build();
        return body;
    }



}
