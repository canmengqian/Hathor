package com.zzz.hathor.codemaker.mapper;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DicDataMapperTest {

    @Autowired
    DicDataMapper mapper;
    @org.junit.Test
    public void queryByCondition() {
        System.out.println(mapper.toString());
        mapper.queryByCondition();
    }
}