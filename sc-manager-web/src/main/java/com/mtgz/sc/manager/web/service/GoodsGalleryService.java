package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.GoodsGalleryMapper;
import com.mtgz.sc.manager.dao.model.GoodsGallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-23 14:41:43
 */
@Service("goodsGalleryService")
public class GoodsGalleryService {
    @Autowired
    private GoodsGalleryMapper goodsGalleryMapper;


    public GoodsGallery queryObject(Integer id) {
        return goodsGalleryMapper.queryObject(id);
    }


    public List<GoodsGallery> queryList(Map<String, Object> map) {
        return goodsGalleryMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return goodsGalleryMapper.queryTotal(map);
    }


    public int save(GoodsGallery goodsGallery) {
        return goodsGalleryMapper.save(goodsGallery);
    }


    public int update(GoodsGallery goodsGallery) {
        return goodsGalleryMapper.update(goodsGallery);
    }


    public int delete(Integer id) {
        return goodsGalleryMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return goodsGalleryMapper.deleteBatch(ids);
    }
}
