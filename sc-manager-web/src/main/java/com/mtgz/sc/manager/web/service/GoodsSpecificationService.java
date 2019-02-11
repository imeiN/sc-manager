package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.GoodsSpecificationMapper;
import com.mtgz.sc.manager.dao.model.GoodsSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品对应规格表值表Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-31 11:15:55
 */
@Service("goodsSpecificationService")
public class GoodsSpecificationService {
    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;


    public GoodsSpecification queryObject(Integer id) {
        return goodsSpecificationMapper.queryObject(id);
    }


    public List<GoodsSpecification> queryList(Map<String, Object> map) {
        return goodsSpecificationMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return goodsSpecificationMapper.queryTotal(map);
    }


    public int save(GoodsSpecification goodsSpecification) {
        return goodsSpecificationMapper.save(goodsSpecification);
    }


    public int update(GoodsSpecification goodsSpecification) {
        return goodsSpecificationMapper.update(goodsSpecification);
    }


    public int delete(Integer id) {
        return goodsSpecificationMapper.delete(id);
    }


    public int deleteBatch(Integer[]ids) {
        return goodsSpecificationMapper.deleteBatch(ids);
    }
}
