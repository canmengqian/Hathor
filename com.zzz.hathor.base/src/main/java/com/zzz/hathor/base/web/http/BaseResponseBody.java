package com.zzz.hathor.base.web.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName BaseResponseBody
 * @Description 基础响应信息
 * @Author 25703
 * @Date 2020/8/18 17:51
 * @Version 1.0.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseBody<T> {

    private String code ; //响应码
    private String message; //响应信息
    private T t;  //响应结果
}
