package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.KeywordsMapper;
import com.mtgz.sc.manager.dao.model.Keywords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 热闹关键词表Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-25 21:23:41
 */
@Service("keywordsService")
public class KeywordsService {
    @Autowired
    private KeywordsMapper keywordsMapper;


    public Keywords queryObject(Integer id) {
        return keywordsMapper.queryObject(id);
    }


    public List<Keywords> queryList(Map<String, Object> map) {
        return keywordsMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return keywordsMapper.queryTotal(map);
    }


    public int save(Keywords keywords) {
        return keywordsMapper.save(keywords);
    }


    public int update(Keywords keywords) {
        return keywordsMapper.update(keywords);
    }


    public int delete(Integer id) {
        return keywordsMapper.delete(id);
    }


    public int deleteBatch(Integer[]ids) {
        return keywordsMapper.deleteBatch(ids);
    }
}
