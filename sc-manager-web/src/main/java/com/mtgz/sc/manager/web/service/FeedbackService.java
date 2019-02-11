package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.FeedbackMapper;
import com.mtgz.sc.manager.dao.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-23 15:03:25
 */
@Service("feedbackService")
public class FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;


    public Feedback queryObject(Integer msgId) {
        return feedbackMapper.queryObject(msgId);
    }


    public List<Feedback> queryList(Map<String, Object> map) {
        return feedbackMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return feedbackMapper.queryTotal(map);
    }


    public int save(Feedback feedback) {
        return feedbackMapper.save(feedback);
    }


    public int update(Feedback feedback) {
        return feedbackMapper.update(feedback);
    }


    public int delete(Integer msgId) {
        return feedbackMapper.delete(msgId);
    }


    public int deleteBatch(Integer[]msgIds) {
        return feedbackMapper.deleteBatch(msgIds);
    }
}
