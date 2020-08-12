package com.zzz.hathor.captcha.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzz.hathor.captcha.domain.entity.DicDataInfo;

import java.util.HashMap;
import java.util.List;

/**
 * 数据字典
 */
public interface DicDataMapper extends BaseMapper<DicDataInfo> {

    public List<HashMap<String,?>> queryByCondition ();
}
