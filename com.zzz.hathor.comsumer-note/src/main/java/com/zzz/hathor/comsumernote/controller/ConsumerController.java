package com.zzz.hathor.comsumernote.controller;

import com.zzz.hathor.base.web.http.BaseResponseBody;
import com.zzz.hathor.base.web.http.SimpleResponseHandler;
import com.zzz.hathor.comsumernote.domain.entity.ConsumerDetailInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ConsumerController
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/8 18:45
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @RequestMapping("/add")
    @ResponseBody
    public BaseResponseBody addConsumerMenu(final List<ConsumerDetailInfo> baseOperator) {
         return SimpleResponseHandler.success(HttpStatus.OK,BaseResponseBody.builder().build());
    }

    @RequestMapping("/query")
    @ResponseBody
    public BaseResponseBody queryConsumerMenu(ConsumerDetailInfo consumerMenu) {
        return SimpleResponseHandler.success(HttpStatus.OK,BaseResponseBody.builder().build());
    }
    @RequestMapping("/update")
    @ResponseBody
    public BaseResponseBody updateConsumerMenu(List<ConsumerDetailInfo> consumerMenu) {
        return SimpleResponseHandler.success(HttpStatus.OK,BaseResponseBody.builder().build());
    }
    @RequestMapping("/delete")
    @ResponseBody
    public BaseResponseBody deleteConsumerMenu(List<ConsumerDetailInfo> consumerMenu) {
        return SimpleResponseHandler.success(HttpStatus.OK,BaseResponseBody.builder().build());
    }
}
