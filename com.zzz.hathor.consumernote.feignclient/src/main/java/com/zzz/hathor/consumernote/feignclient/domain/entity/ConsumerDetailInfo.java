package com.zzz.hathor.consumernote.feignclient.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ConsumerDetailInfo
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/8 18:39
 * @Version 1.0.0
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ConsumerDetailInfo {
    private String  type ; // 商品类型

    private Float price ; // 商品价钱

    private String desc ; // 商品描述

    private String consumerDate ; // 消费日期

    private String createTime ; // 消费单创建时间

    private String currencyType ;// 货币类型


}
