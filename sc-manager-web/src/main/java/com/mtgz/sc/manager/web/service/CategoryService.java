package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.CategoryMapper;
import com.mtgz.sc.manager.dao.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-21 15:32:31
 */
@Service("categoryService")
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    public Category queryObject(Integer id) {
        return categoryMapper.queryObject(id);
    }


    public List<Category> queryList(Map<String, Object> map) {
        return categoryMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return categoryMapper.queryTotal(map);
    }


    public int save(Category category) {
        if ("L1".equals(category.getLevel())) {
            category.setParentId(0);
        }
        return categoryMapper.save(category);
    }


    public int update(Category category) {
        if ("L1".equals(category.getLevel())) {
            category.setParentId(0);
        }
        return categoryMapper.update(category);
    }


    public int delete(Integer id) {
        return categoryMapper.delete(id);
    }


    @Transactional
    public int deleteBatch(Integer[] ids) {
        categoryMapper.deleteByParentBatch(ids);
        return categoryMapper.deleteBatch(ids);
    }
}
