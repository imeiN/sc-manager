package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.BrandMapper;
import com.mtgz.sc.manager.dao.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-19 17:59:15
 */
@Service("brandService")
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;


    public Brand queryObject(Integer id) {
        return brandMapper.queryObject(id);
    }


    public List<Brand> queryList(Map<String, Object> map) {
        return brandMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return brandMapper.queryTotal(map);
    }


    public int save(Brand brand) {
        return brandMapper.save(brand);
    }


    public int update(Brand brand) {
        return brandMapper.update(brand);
    }


    public int delete(Integer id) {
        return brandMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return brandMapper.deleteBatch(ids);
    }
}
