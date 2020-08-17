package com.zzz.hathor.captcha.init;

import com.zzz.hathor.captcha.domain.entity.DicDataInfo;
import com.zzz.hathor.captcha.mapper.DicDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("验证码初始化配置")
@Order(10)
@Slf4j
public class CaptchaInit {
    //@Autowired
    //private RedisTemplate redisTemplate;

    @Autowired
    private DicDataMapper mapper;
    @PostConstruct
    public void init() {
       List<DicDataInfo> rs = mapper.queryByCondition();
       log.info("当前的数据量："+rs.size());
       rs.stream().forEach(info -> {
           log.info(info.toString());
           //redisTemplate.opsForValue().set(info.getKey(),info);
       });
    }
}
