package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.AdMapper;
import com.mtgz.sc.manager.dao.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-19 09:37:35
 */
@Service("adService")
public class AdService {
    @Autowired
    private AdMapper adMapper;

    
    public Ad queryObject(Integer id) {
        return adMapper.queryObject(id);
    }

    
    public List<Ad> queryList(Map<String, Object> map) {
        return adMapper.queryList(map);
    }

    
    public int queryTotal(Map<String, Object> map) {
        return adMapper.queryTotal(map);
    }

    
    public int save(Ad ad) {
        return adMapper.save(ad);
    }

    
    public int update(Ad ad) {
        return adMapper.update(ad);
    }

    
    public int delete(Integer id) {
        return adMapper.delete(id);
    }

    
    public int deleteBatch(Integer[]ids) {
        return adMapper.deleteBatch(ids);
    }
}
