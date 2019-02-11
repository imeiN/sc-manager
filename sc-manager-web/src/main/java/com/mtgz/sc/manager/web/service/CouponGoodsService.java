package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.CouponGoodsMapper;
import com.mtgz.sc.manager.dao.model.CouponGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 优惠券关联商品Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-29 21:50:17
 */
@Service("couponGoodsService")
public class CouponGoodsService {
    @Autowired
    private CouponGoodsMapper couponGoodsMapper;


    public CouponGoods queryObject(Integer id) {
        return couponGoodsMapper.queryObject(id);
    }


    public List<CouponGoods> queryList(Map<String, Object> map) {
        return couponGoodsMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return couponGoodsMapper.queryTotal(map);
    }


    public int save(CouponGoods couponGoods) {
        return couponGoodsMapper.save(couponGoods);
    }


    public int update(CouponGoods couponGoods) {
        return couponGoodsMapper.update(couponGoods);
    }


    public int delete(Integer id) {
        return couponGoodsMapper.delete(id);
    }


    public int deleteBatch(Integer[]ids) {
        return couponGoodsMapper.deleteBatch(ids);
    }
}
