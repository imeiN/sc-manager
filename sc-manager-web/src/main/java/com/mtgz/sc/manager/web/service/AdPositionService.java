package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.AdPositionMapper;
import com.mtgz.sc.manager.dao.model.AdPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-19 12:02:42
 */
@Service("adPositionService")
public class AdPositionService {
    @Autowired
    private AdPositionMapper adPositionMapper;

    
    public AdPosition queryObject(Integer id) {
        return adPositionMapper.queryObject(id);
    }

    
    public List<AdPosition> queryList(Map<String, Object> map) {
        return adPositionMapper.queryList(map);
    }

    
    public int queryTotal(Map<String, Object> map) {
        return adPositionMapper.queryTotal(map);
    }

    
    public int save(AdPosition adPosition) {
        return adPositionMapper.save(adPosition);
    }

    
    public int update(AdPosition adPosition) {
        return adPositionMapper.update(adPosition);
    }

    
    public int delete(Integer id) {
        return adPositionMapper.delete(id);
    }

    
    public int deleteBatch(Integer[] ids) {
        return adPositionMapper.deleteBatch(ids);
    }
}
