package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.HelpTypeMapper;
import com.mtgz.sc.manager.dao.model.HelpType;
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
@Service("helpTypeService")
public class HelpTypeService {
    @Autowired
    private HelpTypeMapper helpTypeMapper;


    public HelpType queryObject(Integer id) {
        return helpTypeMapper.queryObject(id);
    }


    public List<HelpType> queryList(Map<String, Object> map) {
        return helpTypeMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return helpTypeMapper.queryTotal(map);
    }


    public int save(HelpType helpType) {
        return helpTypeMapper.save(helpType);
    }


    public int update(HelpType helpType) {
        return helpTypeMapper.update(helpType);
    }


    public int delete(Integer id) {
        return helpTypeMapper.delete(id);
    }


    public int deleteBatch(Integer[]ids) {
        return helpTypeMapper.deleteBatch(ids);
    }
}
