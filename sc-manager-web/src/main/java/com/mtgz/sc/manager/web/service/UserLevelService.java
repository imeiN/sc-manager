package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.UserLevelMapper;
import com.mtgz.sc.manager.dao.model.UserLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-16 16:52:22
 */
@Service("userLevelService")
public class UserLevelService {
    @Autowired
    private UserLevelMapper userLevelMapper;


    public UserLevel queryObject(Integer id) {
        return userLevelMapper.queryObject(id);
    }


    public List<UserLevel> queryList(Map<String, Object> map) {
        return userLevelMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return userLevelMapper.queryTotal(map);
    }


    public int save(UserLevel userLevel) {
        return userLevelMapper.save(userLevel);
    }


    public int update(UserLevel userLevel) {
        return userLevelMapper.update(userLevel);
    }


    public int delete(Integer id) {
        return userLevelMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return userLevelMapper.deleteBatch(ids);
    }
}
