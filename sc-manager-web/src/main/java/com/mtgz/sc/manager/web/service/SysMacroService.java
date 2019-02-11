package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.common.entity.SysMacroEntity;
import com.mtgz.sc.manager.dao.mapper.SysMacroMapper;
import com.mtgz.sc.manager.web.compoent.CacheUtils;
import com.mtgz.sc.manager.web.compoent.redisson.RedissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用字典表Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-22 11:48:16
 */
@Service("sysMacroService")
public class SysMacroService {
    @Autowired
    private SysMacroMapper sysMacroMapper;

    @Autowired
    CacheUtils cacheUtils;

    
    public SysMacroEntity queryObject(Long macroId) {
        return sysMacroMapper.queryObject(macroId);
    }

    
    public List<SysMacroEntity> queryList(Map<String, Object> map) {
        return sysMacroMapper.queryList(map);
    }

    
    public int queryTotal(Map<String, Object> map) {
        return sysMacroMapper.queryTotal(map);
    }

    
    public int save(SysMacroEntity sysMacro) {
        sysMacro.setGmtCreate(new Date());
        sysMacroMapper.save(sysMacro);
        cacheUtils.put("macroList", queryList(new HashMap<>()));
        return 1;
    }

    
    public int update(SysMacroEntity sysMacro) {
        sysMacro.setGmtModified(new Date());
        sysMacroMapper.update(sysMacro);
        cacheUtils.put("macroList", queryList(new HashMap<>()));
        return 1;
    }

    
    public int delete(Long macroId) {
        sysMacroMapper.delete(macroId);
        cacheUtils.put("macroList", queryList(new HashMap<>()));
        return 1;
    }

    
    public int deleteBatch(Long[] macroIds) {
        sysMacroMapper.deleteBatch(macroIds);
        cacheUtils.put("macroList", queryList(new HashMap<>()));
        return 1;
    }

    
    public List<SysMacroEntity> queryMacrosByValue(String value) {
        return sysMacroMapper.queryMacrosByValue(value);
    }
}
