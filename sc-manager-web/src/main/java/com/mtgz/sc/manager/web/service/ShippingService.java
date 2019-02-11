package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.ShippingMapper;
import com.mtgz.sc.manager.dao.model.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-09-04 21:42:24
 */
@Service("shippingService")
public class ShippingService {
    @Autowired
    private ShippingMapper shippingMapper;


    public Shipping queryObject(Integer id) {
        return shippingMapper.queryObject(id);
    }


    public List<Shipping> queryList(Map<String, Object> map) {
        return shippingMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return shippingMapper.queryTotal(map);
    }


    public int save(Shipping shipping) {
        return shippingMapper.save(shipping);
    }


    public int update(Shipping shipping) {
        return shippingMapper.update(shipping);
    }


    public int delete(Integer id) {
        return shippingMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return shippingMapper.deleteBatch(ids);
    }
}
