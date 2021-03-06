package com.zzz.hathor.captcha.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.zzz.hathor.captcha.domain.Enum.VerifyResultEnum;
import com.zzz.hathor.captcha.domain.dto.CaptchaInfo;
import com.zzz.hathor.captcha.domain.dto.CaptchaVerify;
import com.zzz.hathor.captcha.service.CaptchaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Date;

@Service
@Slf4j
public class ImageCapchaServiceImpl implements CaptchaService {

    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public BufferedImage getCaptcha(CaptchaInfo info) {
        LineCaptcha line = CaptchaUtil.createLineCaptcha(200, 100);
        log.info("当前获取的验证码为:"+line.getCode());
        redisTemplate.opsForValue().set(info.getProducer(),line.getCode());
       return line.getImage();
    }
    @Override
    public CaptchaVerify verifyCode(CaptchaVerify info) {
        CaptchaVerify result;
       String value= (String) redisTemplate.opsForValue().get(info.getToken());
        log.info("当前获取的验证码为:"+value);
        if(value!= null) {
            result= CaptchaVerify.builder()
                    .correctCode(value).answer(info.getAnswer())
                    .token(info.getToken()).result(VerifyResultEnum.SUCCESS).pushtime(new Date().toLocaleString()).build();
        }else {
             result = CaptchaVerify.builder()
                    .correctCode("").answer(info.getAnswer())
                    .token(info.getToken()).result(VerifyResultEnum.FAIL).pushtime(new Date().toLocaleString()).build();
        }
        return result;
    }
}
