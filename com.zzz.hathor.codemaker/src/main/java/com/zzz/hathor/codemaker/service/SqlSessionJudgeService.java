package com.zzz.hathor.codemaker.service;

import org.apache.ibatis.session.SqlSession;

/**
 * @ClassName SqlSessionJudgeService
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/10 17:21
 * @Version 1.0.0
 **/
public interface SqlSessionJudgeService {
    public SqlSession judgeSqlSession(String vender);
}
