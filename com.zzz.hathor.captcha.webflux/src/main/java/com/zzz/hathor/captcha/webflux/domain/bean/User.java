package com.zzz.hathor.captcha.webflux.domain.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Author 25703
 * @Date 2020/8/25 18:12
 * @Version 1.0.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private String age;
}
