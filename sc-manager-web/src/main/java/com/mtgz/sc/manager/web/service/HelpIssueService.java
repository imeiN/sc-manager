package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.HelpIssueMapper;
import com.mtgz.sc.manager.dao.model.HelpIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-07 10:09:54
 */
@Service("helpIssueService")
public class HelpIssueService {
    @Autowired
    private HelpIssueMapper helpIssueMapper;


    public HelpIssue queryObject(Integer id) {
        return helpIssueMapper.queryObject(id);
    }


    public List<HelpIssue> queryList(Map<String, Object> map) {
        return helpIssueMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return helpIssueMapper.queryTotal(map);
    }


    public int save(HelpIssue helpIssue) {
        return helpIssueMapper.save(helpIssue);
    }


    public int update(HelpIssue helpIssue) {
        return helpIssueMapper.update(helpIssue);
    }


    public int delete(Integer id) {
        return helpIssueMapper.delete(id);
    }


    public int deleteBatch(Integer[]ids) {
        return helpIssueMapper.deleteBatch(ids);
    }
}
