package com.zzz.hathor.captcha.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("captcha")
@RestController
public class CaptchaController {
    @RequestMapping("/query")
    public  String captcha() {
        return  "Hello world ";
    }
}
