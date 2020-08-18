package com.zzz.hathor.captcha.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import com.zzz.hathor.captcha.common.constant.AppServiceConstant;
import com.zzz.hathor.captcha.service.impl.ImageCapchaServiceImpl;
import com.zzz.hathor.captcha.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@RequestMapping("captcha")
@RestController
@Api(tags = AppServiceConstant.CAPTCHA_SERVICE_NAME)
public class CaptchaController {

    @Autowired
    ImageCapchaServiceImpl service;
    @Resource
    private HttpServletResponse response;

    @RequestMapping("/query")
    public  String captcha() {
     return   MessageUtil.get("username.login.error");
    }

    @RequestMapping(value="/image")
    @ApiOperation("获取图片-以ImageIO流形式写回")
    public  void imageCaptcha() throws IOException {

        response.setContentType("image/png");
        BufferedImage bufferedImage = service.getCaptcha(null);

           OutputStream os =response.getOutputStream();
        ImageIO.write(bufferedImage,"png",os);
        os.flush();
        os.close();
    }

    @RequestMapping(value="/error")
    @ApiOperation("获取图片-以ImageIO流形式写回")
    public  void error()  {

       throw  new NullPointerException();
    }
}
