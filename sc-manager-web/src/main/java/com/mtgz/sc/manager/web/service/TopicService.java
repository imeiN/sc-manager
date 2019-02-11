package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.TopicMapper;
import com.mtgz.sc.manager.dao.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-20 14:10:08
 */
@Service("topicService")
public class TopicService {
    @Autowired
    private TopicMapper topicMapper;


    public Topic queryObject(Integer id) {
        return topicMapper.queryObject(id);
    }


    public List<Topic> queryList(Map<String, Object> map) {
        return topicMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return topicMapper.queryTotal(map);
    }


    public int save(Topic topic) {
        return topicMapper.save(topic);
    }


    public int update(Topic topic) {
        return topicMapper.update(topic);
    }


    public int delete(Integer id) {
        return topicMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return topicMapper.deleteBatch(ids);
    }
}
