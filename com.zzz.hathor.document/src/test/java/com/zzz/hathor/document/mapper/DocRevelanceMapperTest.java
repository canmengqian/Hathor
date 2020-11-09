package com.zzz.hathor.document.mapper;

import com.zzz.hathor.document.domain.entity.DocEntity;
import com.zzz.hathor.document.domain.entity.DocRelevanceEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocRevelanceMapperTest {
    @Autowired
    private DocRevelanceMapper revelanceMapper;

    @Test
    public void addSelect() {
        System.out.println(("----- add method test ------"));
       int key = revelanceMapper.insert(DocRelevanceEntity.builder().docId(UUID.randomUUID().toString()).linkTitle("aa").build());

    }
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<DocRelevanceEntity> list = revelanceMapper.selectList(null);

    }
}