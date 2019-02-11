package com.mtgz.sc.manager.dao.mapper;

import com.mtgz.sc.manager.dao.config.MyMapper;
import com.mtgz.sc.manager.dao.model.GoodsAttribute;

public interface GoodsAttributeMapper extends MyMapper<GoodsAttribute> {
    int updateByGoodsIdAttributeId(GoodsAttribute goodsAttribute);
}