package com.zzz.hathor.base.web.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName BaseRequest
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/8 18:18
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseRequest<T> {
  private   T t ;

}
