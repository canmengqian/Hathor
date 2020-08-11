package com.zzz.hathor.captcha;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class CaptchaApplicationTests {

    @Autowired
    RedisTemplate  redisTemplate ;
    @Test
    void contextLoads() {
        log.info(""+redisTemplate.hashCode());
    }

}
