package com.zzz.hathor.captcha.service;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.zzz.hathor.captcha.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;

@Slf4j
public class JsonParseTest{

    @Test
    public  void testParseJson() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("1",new Integer(1));
        map.put("2","2");
       JSON json =  JSONUtil.parse(map);
       log.info(json.toStringPretty());;
    }
}
