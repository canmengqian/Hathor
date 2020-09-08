package com.zzz.hathor.captcha.controller;

import com.zzz.hathor.base.web.http.BaseResponseBody;
import com.zzz.hathor.captcha.common.constant.AppServiceConstant;
import com.zzz.hathor.captcha.config.config.RestRequestHelper;
import com.zzz.hathor.captcha.domain.dto.CaptchaInfo;
import com.zzz.hathor.captcha.domain.dto.CaptchaVerify;
import com.zzz.hathor.captcha.service.impl.ImageCapchaServiceImpl;
import com.zzz.hathor.captcha.util.MessageUtil;
import com.zzz.hathor.captcha.util.SimpleResponseHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@RequestMapping("captcha")
@RestController
@Api(tags = AppServiceConstant.CAPTCHA_SERVICE_NAME)
@Slf4j
public class CaptchaController {

    @Autowired
    ImageCapchaServiceImpl service;
    @Resource
    private HttpServletResponse response;

    @RequestMapping(value = "/query",method= RequestMethod.GET)
    @RestRequestHelper
    public  String captcha() {
     return   MessageUtil.get("username.login.error");
    }

    @RequestMapping(value="/image",method= RequestMethod.GET )
    @ApiOperation("获取图片")
    public  void imageCaptcha( CaptchaInfo info) throws IOException {
        response.setContentType("image/png");
        BufferedImage bufferedImage = service.getCaptcha(info);
        OutputStream os =response.getOutputStream();
        ImageIO.write(bufferedImage,"png",os);
        os.flush();
        os.close();
    }

    @RequestMapping(value="/error",method= RequestMethod.DELETE)

    @ApiOperation("异常测试")
    public  void error()  {
       throw  new NullPointerException();
    }

    @RequestMapping(value = "/verify" ,method= RequestMethod.GET)
    public BaseResponseBody verifyCode(CaptchaVerify verify) {
       BaseResponseBody<CaptchaVerify> resp = new BaseResponseBody<>();
       log.info(verify.toString());
        CaptchaVerify verifyResult = service.verifyCode(verify);
        return SimpleResponseHandler.success(HttpStatus.OK,resp.builder().t(verifyResult).code("200").message("验证成功").build());
    }
}
