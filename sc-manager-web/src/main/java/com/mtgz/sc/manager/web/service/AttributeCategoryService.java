package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.AttributeCategoryMapper;
import com.mtgz.sc.manager.dao.model.AttributeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-17 16:13:27
 */
@Service("attributeCategoryService")
public class AttributeCategoryService  {
    @Autowired
    private AttributeCategoryMapper attributeCategoryMapper;

    
    public AttributeCategory queryObject(Integer id) {
        return attributeCategoryMapper.queryObject(id);
    }


    public List<AttributeCategory> queryList(Map<String, Object> map) {
        return attributeCategoryMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return attributeCategoryMapper.queryTotal(map);
    }


    public int save(AttributeCategory attributeCategory) {
        return attributeCategoryMapper.save(attributeCategory);
    }


    public int update(AttributeCategory attributeCategory) {
        return attributeCategoryMapper.update(attributeCategory);
    }

    
    public int delete(Integer id) {
        return attributeCategoryMapper.delete(id);
    }

    
    public int deleteBatch(Integer[] ids) {
        return attributeCategoryMapper.deleteBatch(ids);
    }
}
