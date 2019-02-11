package com.mtgz.sc.manager.dao.mapper;

import com.mtgz.sc.manager.dao.config.MyMapper;
import com.mtgz.sc.manager.dao.model.Goods;

public interface GoodsMapper extends MyMapper<Goods> {
    int queryMaxId();
}