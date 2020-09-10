package com.zzz.hathor.codemaker.mapper.sqlite;

import com.zzz.hathor.codemaker.domain.entity.sqlite.TableInfo;

import java.util.List;

/**
 *
 */
public interface TableInfoMapper {
    public List<TableInfo> queryTables();
}
