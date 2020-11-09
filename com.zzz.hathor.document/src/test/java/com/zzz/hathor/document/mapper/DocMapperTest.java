package com.zzz.hathor.document.mapper;

import com.zzz.hathor.document.domain.entity.DocEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocMapperTest {
    @Autowired
    private DocMapper docMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<DocEntity> userList = docMapper.selectList(null);

    }

}