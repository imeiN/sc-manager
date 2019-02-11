package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.TopicCategoryMapper;
import com.mtgz.sc.manager.dao.model.TopicCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-20 15:41:56
 */
@Service("topicCategoryService")
public class TopicCategoryService {
    @Autowired
    private TopicCategoryMapper topicCategoryMapper;


    public TopicCategory queryObject(Integer id) {
        return topicCategoryMapper.queryObject(id);
    }


    public List<TopicCategory> queryList(Map<String, Object> map) {
        return topicCategoryMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return topicCategoryMapper.queryTotal(map);
    }


    public int save(TopicCategory topicCategory) {
        return topicCategoryMapper.save(topicCategory);
    }


    public int update(TopicCategory topicCategory) {
        return topicCategoryMapper.update(topicCategory);
    }


    public int delete(Integer id) {
        return topicCategoryMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return topicCategoryMapper.deleteBatch(ids);
    }
}
