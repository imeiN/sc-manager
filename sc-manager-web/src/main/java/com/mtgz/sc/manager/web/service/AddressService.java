package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.AddressMapper;
import com.mtgz.sc.manager.dao.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-16 17:22:46
 */
@Service("addressService")
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;

    
    public Address queryObject(Integer id) {
        return addressMapper.queryObject(id);
    }

    
    public List<Address> queryList(Map<String, Object> map) {
        List<Address> list = addressMapper.queryList(map);
        if (null != list && list.size() > 0) {
            for (Address address : list) {
                //翻译收货地址国家码

            }
        }
        return list;
    }

    
    public int queryTotal(Map<String, Object> map) {
        return addressMapper.queryTotal(map);
    }

    
    public int save(Address address) {
        return addressMapper.save(address);
    }

    
    public int update(Address address) {
        return addressMapper.update(address);
    }

    
    public int delete(Integer id) {
        return addressMapper.delete(id);
    }

    
    public int deleteBatch(Integer[] ids) {
        return addressMapper.deleteBatch(ids);
    }
}
