package com.zzz.hathor.captcha.mapper;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.zzz.hathor.captcha.domain.dto.PropertyInfo;
import com.zzz.hathor.captcha.domain.entity.DicDataInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DicDataMapperTest {
    @Autowired
    DicDataMapper mapper ;
    @Test
    public  void testSelect() {
        log.info(mapper.hashCode()+"");
       List<DicDataInfo> infos =  mapper.queryByCondition();
       log.info(infos.toString());
       List<DicDataInfo> rs =  mapper.selectList(null);
       log.info(rs.toString());
    }
    @Test
    public  void testAdd() {
        DicDataInfo info = new DicDataInfo();
        info.setClazzName(List.class.getClass().getName());
        info.setDesc("test");
        info.setKey("test");

        HashMap<String,Object> map = new HashMap<>();
        map.put("1",new Integer(1));
        map.put("2","2");
        JSON json =  JSONUtil.parse(map);
        info.setValue(json.toString());
        int rs= mapper.insert(info);
        log.info(rs+"");
    }
}
