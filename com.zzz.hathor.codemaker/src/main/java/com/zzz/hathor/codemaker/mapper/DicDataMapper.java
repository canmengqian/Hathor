package com.zzz.hathor.codemaker.mapper;


import com.zzz.hathor.codemaker.domain.entity.DicDataInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 数据字典
 */
public interface DicDataMapper {

    @Transactional
    public List<DicDataInfo> queryByCondition();
}
