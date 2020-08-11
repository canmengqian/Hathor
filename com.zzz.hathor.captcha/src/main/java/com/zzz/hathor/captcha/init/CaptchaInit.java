package com.zzz.hathor.captcha.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("验证码初始化配置")
@Order(10)
@Slf4j
public class CaptchaInit {
    @Autowired
    private RedisTemplate redisTemplate;
    @PostConstruct
    public void init() {
        for(int i =0  ;i<100;i++) {
            log.info("验证码初始化");
            log.info(redisTemplate.hashCode()+"");
        }

    }
}
