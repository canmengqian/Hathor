package com.zzz.hathor.codemaker.mapper;


import com.zzz.hathor.codemaker.domain.entity.DicDataInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据字典
 */
public interface DicDataMapper {

    public List<DicDataInfo> queryByCondition();
}
