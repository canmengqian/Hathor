package com.zzz.hathor.captcha.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzz.hathor.captcha.domain.entity.DicDataInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 数据字典
 */
@Mapper
public interface DicDataMapper extends BaseMapper<DicDataInfo> {

    public List<DicDataInfo> queryByCondition ();
}
