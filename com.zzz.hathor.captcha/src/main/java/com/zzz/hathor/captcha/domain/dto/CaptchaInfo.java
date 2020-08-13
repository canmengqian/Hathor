package com.zzz.hathor.captcha.domain.dto;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;

@Data
@ToString
public class CaptchaInfo {
    private String type ;
    private String producer;
    private List<PropertyInfo> configs ;
}
