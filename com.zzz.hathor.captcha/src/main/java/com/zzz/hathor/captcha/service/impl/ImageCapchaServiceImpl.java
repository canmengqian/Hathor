package com.zzz.hathor.captcha.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.zzz.hathor.captcha.domain.dto.CaptchaInfo;
import com.zzz.hathor.captcha.service.CaptchaService;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
@Service
public class ImageCapchaServiceImpl implements CaptchaService {
    @Override
    public BufferedImage getCaptcha(CaptchaInfo info) {
        LineCaptcha line = CaptchaUtil.createLineCaptcha(200, 100);
       return line.getImage();

    }
}
