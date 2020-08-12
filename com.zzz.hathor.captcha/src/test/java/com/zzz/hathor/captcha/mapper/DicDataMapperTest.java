package com.zzz.hathor.captcha.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DicDataMapperTest {
    @Autowired
    DicDataMapper mapper ;
    @Test
    public  void testSelect() {
        log.info(mapper.hashCode()+"");
    }
}
