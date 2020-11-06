package com.zzz.hathor.consumernote.feignclient.controller;

import com.zzz.hathor.base.web.http.BaseResponseBody;
import com.zzz.hathor.base.web.http.SimpleResponseHandler;
import com.zzz.hathor.consumernote.feignclient.domain.entity.ConsumerDetailInfo;
import com.zzz.hathor.consumernote.feignclient.service.ConsumerMenuServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ConsumerMenuServiceClient client;
    @RequestMapping("/add")
    @ResponseBody
    public BaseResponseBody addConsumerMenu(final List<ConsumerDetailInfo> baseOperator) {
        List<String> list = client.queryComsumerMenus();
         return SimpleResponseHandler.success(HttpStatus.OK,BaseResponseBody.builder().build());
    }

    @RequestMapping("/query")
    @ResponseBody
    public BaseResponseBody queryConsumerMenu(ConsumerDetailInfo consumerMenu) {
        List<String> list = client.queryComsumerMenus();
        return SimpleResponseHandler.success(HttpStatus.OK,BaseResponseBody.builder().data(list.size()).build());
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
