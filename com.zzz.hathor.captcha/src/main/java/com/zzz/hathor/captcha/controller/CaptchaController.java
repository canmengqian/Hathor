package com.zzz.hathor.captcha.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import com.zzz.hathor.cache.util.anotation.ExpireType;
import com.zzz.hathor.cache.util.anotation.Resources;
import com.zzz.hathor.cache.util.anotation.SimpleCache;
import com.zzz.hathor.captcha.common.constant.AppServiceConstant;
import com.zzz.hathor.captcha.config.config.RestRequestHelper;
import com.zzz.hathor.captcha.domain.dto.CaptchaInfo;
import com.zzz.hathor.captcha.domain.dto.CaptchaVerify;
import com.zzz.hathor.captcha.domain.entity.BaseResponseBody;
import com.zzz.hathor.captcha.service.impl.ImageCapchaServiceImpl;
import com.zzz.hathor.captcha.util.MessageUtil;
import com.zzz.hathor.captcha.util.SimpleResponseHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

@RequestMapping("captcha")
@RestController
@Api(tags = AppServiceConstant.CAPTCHA_SERVICE_NAME)
public class CaptchaController {

    @Autowired
    ImageCapchaServiceImpl service;
    @Resource
    private HttpServletResponse response;

    @RequestMapping(value = "/query",method= RequestMethod.GET)
    @RestRequestHelper
    @SimpleCache(expireTime=10,key="marketExponent",policy= ExpireType.TIME,unit= TimeUnit.DAYS,
            resources=@Resources(repository = Object.class,method="querymarketExponent"))
    public  String captcha() {
     return   MessageUtil.get("username.login.error");
    }

    @RequestMapping(value="/image",method= RequestMethod.GET )
    @ApiOperation("获取图片-以ImageIO流形式写回")
    public  void imageCaptcha( CaptchaInfo info) throws IOException {
        response.setContentType("image/png");
        BufferedImage bufferedImage = service.getCaptcha(info);
        OutputStream os =response.getOutputStream();
        ImageIO.write(bufferedImage,"png",os);
        os.flush();
        os.close();
    }

    @RequestMapping(value="/error",method= RequestMethod.DELETE)

    @ApiOperation("获取图片-以ImageIO流形式写回")
    public  void error()  {
       throw  new NullPointerException();
    }

    @RequestMapping(value = "/verify" ,method= RequestMethod.GET)
    public BaseResponseBody verifyCode(CaptchaVerify verify) {
       BaseResponseBody<CaptchaVerify> resp = new BaseResponseBody<>();
       return SimpleResponseHandler.success(HttpStatus.OK,resp);
    }
}
