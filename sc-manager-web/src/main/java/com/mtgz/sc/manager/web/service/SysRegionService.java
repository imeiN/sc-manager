package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.common.entity.SysRegionEntity;
import com.mtgz.sc.manager.dao.mapper.SysRegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-11-04 11:19:31
 */
@Service("regionService")
public class SysRegionService {
    @Autowired
    private SysRegionMapper sysRegionMapper;

    
    public SysRegionEntity queryObject(Integer id) {
        return sysRegionMapper.queryObject(id);
    }

    
    public List<SysRegionEntity> queryList(Map<String, Object> map) {
        return sysRegionMapper.queryList(map);
    }

    
    public int queryTotal(Map<String, Object> map) {
        return sysRegionMapper.queryTotal(map);
    }

    
    public int save(SysRegionEntity region) {
        return sysRegionMapper.save(region);
    }

    
    public int update(SysRegionEntity region) {
        return sysRegionMapper.update(region);
    }

    
    public int delete(Integer id) {
        return sysRegionMapper.delete(id);
    }

    
    public int deleteBatch(Integer[] ids) {
        return sysRegionMapper.deleteBatch(ids);
    }
}
