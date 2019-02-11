package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.GoodsIssueMapper;
import com.mtgz.sc.manager.dao.model.GoodsIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-23 14:12:34
 */
@Service("goodsIssueService")
public class GoodsIssueService {
    @Autowired
    private GoodsIssueMapper goodsIssueMapper;


    public GoodsIssue queryObject(Integer id) {
        return goodsIssueMapper.queryObject(id);
    }


    public List<GoodsIssue> queryList(Map<String, Object> map) {
        return goodsIssueMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return goodsIssueMapper.queryTotal(map);
    }


    public int save(GoodsIssue goodsIssue) {
        return goodsIssueMapper.save(goodsIssue);
    }


    public int update(GoodsIssue goodsIssue) {
        return goodsIssueMapper.update(goodsIssue);
    }


    public int delete(Integer id) {
        return goodsIssueMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return goodsIssueMapper.deleteBatch(ids);
    }
}
