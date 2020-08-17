package com.zzz.hathor.captcha.service.impl;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.google.code.kaptcha.util.ConfigHelper;
import com.zzz.hathor.captcha.domain.dto.CaptchaInfo;
import com.zzz.hathor.captcha.service.SimpleCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.OutputStream;

public class SimpleCaptchaImpl implements SimpleCaptcha {

    @Autowired
    private RedisTemplate redisTemplate;
    public OutputStream gennerCaptcha(CaptchaInfo info) {
        return null;


    }

    public  Config loadConfig(CaptchaInfo info) {
    return null;
    }
    public static void main(String[] args) {
        //Config config = new Config();
    }

}
