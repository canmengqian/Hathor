package com.zzz.hathor.base.web.http;
import org.springframework.http.HttpStatus;

/**
 * @ClassName SimplResponseHandler
 * @Description 响应结果处理器
 * @Author 25703
 * @Date 2020/8/18 17:55
 * @Version 1.0.0
 **/
public class SimpleResponseHandler {
   public  static BaseResponseBody fail(String code , String msg) {
       BaseResponseBody body = BaseResponseBody.builder().code(code).message(msg).build();
       return body;
   }

   public static BaseResponseBody fail(String code, String msg, Object  result) {
       BaseResponseBody body = BaseResponseBody.builder().code(code).message(msg).data(result).build();
       return  body;
   }


    public static BaseResponseBody fail(String code ,String msg ,Throwable throwable) {
        BaseResponseBody body = BaseResponseBody.builder().code(code).message(msg).data(throwable.getMessage()).build();
        return  body;
    }

    public static BaseResponseBody fail(HttpStatus status, Object  result) {

        BaseResponseBody body = BaseResponseBody.builder().code(String.valueOf(status.value())).message(status.getReasonPhrase()).data(result).build();
        return body;
    }

    public static BaseResponseBody success(String code ,String msg) {
        BaseResponseBody body = BaseResponseBody.builder().code(code).message(msg).build();
        return body;
    }

    public static BaseResponseBody success(String code ,String msg,Object  result) {
        BaseResponseBody body = BaseResponseBody.builder().code(code).message(msg).data(result).build();
        return body;
    }

    public static BaseResponseBody success(HttpStatus status, Object  result) {
        BaseResponseBody body = BaseResponseBody.builder().code(String.valueOf(status.value())).message(status.getReasonPhrase()).data(result).build();
        return body;
    }





}
