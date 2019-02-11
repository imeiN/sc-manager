package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.UserMapper;
import com.mtgz.sc.manager.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-16 15:02:28
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public User queryObject(Integer id) {
        return userMapper.queryObject(id);
    }


    public List<User> queryList(Map<String, Object> map) {
        return userMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return userMapper.queryTotal(map);
    }


    public int save(User user) {
        user.setRegisterTime(new Date());
        return userMapper.save(user);
    }


    public int update(User user) {
        return userMapper.update(user);
    }


    public int delete(Integer id) {
        return userMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return userMapper.deleteBatch(ids);
    }
}
