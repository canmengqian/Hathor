package com.zzz.hathor.captcha.service;

import com.zzz.hathor.captcha.domain.dto.CaptchaInfo;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public  interface CaptchaService {

    public BufferedImage getCaptcha(CaptchaInfo info) ;

}
