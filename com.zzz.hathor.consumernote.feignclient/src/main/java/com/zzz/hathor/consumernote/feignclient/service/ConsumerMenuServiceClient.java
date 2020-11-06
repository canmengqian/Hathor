package com.zzz.hathor.consumernote.feignclient.service;

import com.zzz.hathor.comsumernote.service.ConsumerMenuService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * 消费清单服务
 */
@FeignClient(value = "comsumernote-provider")
public interface ConsumerMenuServiceClient extends ConsumerMenuService {
}
