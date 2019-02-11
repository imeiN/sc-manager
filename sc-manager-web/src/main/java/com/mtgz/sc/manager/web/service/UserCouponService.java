package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.UserCouponMapper;
import com.mtgz.sc.manager.dao.model.UserCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-19 15:40:33
 */
@Service("userCouponService")
public class UserCouponService {
    @Autowired
    private UserCouponMapper userCouponMapper;


    public UserCoupon queryObject(Integer id) {
        return userCouponMapper.queryObject(id);
    }


    public List<UserCoupon> queryList(Map<String, Object> map) {
        return userCouponMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return userCouponMapper.queryTotal(map);
    }


    public int save(UserCoupon userCoupon) {
        return userCouponMapper.save(userCoupon);
    }


    public int update(UserCoupon userCoupon) {
        return userCouponMapper.update(userCoupon);
    }


    public int delete(Integer id) {
        return userCouponMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return userCouponMapper.deleteBatch(ids);
    }
}
