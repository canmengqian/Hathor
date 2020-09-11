package com.zzz.hathor.codemaker.mapper.oracle;

import com.zzz.hathor.codemaker.domain.entity.TableInfoEntity;

import java.util.List;

/**
 *
 */
public interface RepositoryMapper {
    public List<TableInfoEntity> queryTables();
}
