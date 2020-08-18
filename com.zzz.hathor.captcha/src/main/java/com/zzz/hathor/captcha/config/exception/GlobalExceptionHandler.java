package com.zzz.hathor.captcha.config.exception;

import com.zzz.hathor.captcha.domain.entity.BaseResponseBody;
import com.zzz.hathor.captcha.util.SimpleResponseHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author 25703
 * @Date 2020/8/18 17:37
 * @Version 1.0.0
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public BaseResponseBody exceptionHandler(Exception e){
        return SimpleResponseHandler.fail("500","内部服务器错误",e.getCause());
    }



}
