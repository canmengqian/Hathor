package com.zzz.hathor.captcha.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CaptchaVerify
 * @Description TODO
 * @Author 25703
 * @Date 2020/8/21 16:40
 * @Version 1.0.0
 **/
@ApiModel(value="验证码验证信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaptchaVerify {
    @ApiParam("token号")
    private String token;
    @ApiParam("回复码")
    private String  answer;
    @ApiParam("正确码")
    private String  correctCode;

    @ApiParam("推送过来的时间")
    private String  recivetime;

    @ApiParam("回复时间")
    private String  pushtime;

    @ApiParam("验证结果")
    private Enum result;

}
