package com.zzz.hathor.captcha;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
public class RedisTemplateTest extends  BaseTest{
    @Autowired
    RedisTemplate redisTemplate ;
    @Test
    public  void  putStr() {
        String  val = (String) redisTemplate.opsForValue().get(""+1);
        log.info(val);
        /*for(int  i=0;i<100;i++) {
            redisTemplate.opsForValue().set(""+i,i+"");
            String  val = (String) redisTemplate.opsForValue().get(""+1);
            log.info(val);
        }*/

    }
}
