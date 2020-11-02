package com.zzz.hathor.codemaker.service;

import com.zzz.hathor.codemaker.domain.vo.query.DataSourceInfoQuery;

import java.util.List;

public interface TableInfoService<M> {
    public List<M> queryTableMetaInfo(DataSourceInfoQuery query) throws Exception;
}
