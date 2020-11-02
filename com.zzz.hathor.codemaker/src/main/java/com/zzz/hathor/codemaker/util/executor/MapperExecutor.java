package com.zzz.hathor.codemaker.util.executor;

import com.zzz.hathor.codemaker.domain.entity.TableInfoEntity;
import com.zzz.hathor.codemaker.mapper.RepositoryMapper;

import java.util.List;

public interface MapperExecutor<T extends RepositoryMapper,R extends TableInfoEntity> {
    public static  final  String METHOD_QUERY_FREFIX = "queryBy";
    public List<R> execut(Object... objs) throws Exception;
}
