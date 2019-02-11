package com.mtgz.sc.manager.dao.mapper;

import com.mtgz.sc.manager.dao.config.MyMapper;
import com.mtgz.sc.manager.dao.model.GoodsGallery;

import java.util.Map;

public interface GoodsGalleryMapper extends MyMapper<GoodsGallery> {
    void deleteByGoodsId(Map<String, Integer> map);
}