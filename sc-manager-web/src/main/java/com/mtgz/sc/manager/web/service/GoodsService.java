package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.common.entity.SysUserEntity;
import com.mtgz.sc.manager.common.util.RRException;
import com.mtgz.sc.manager.common.util.ShiroUtils;
import com.mtgz.sc.manager.dao.mapper.GoodsAttributeMapper;
import com.mtgz.sc.manager.dao.mapper.GoodsGalleryMapper;
import com.mtgz.sc.manager.dao.mapper.GoodsMapper;
import com.mtgz.sc.manager.dao.mapper.ProductMapper;
import com.mtgz.sc.manager.dao.model.Goods;
import com.mtgz.sc.manager.dao.model.GoodsAttribute;
import com.mtgz.sc.manager.dao.model.GoodsGallery;
import com.mtgz.sc.manager.dao.model.Product;
import com.mtgz.sc.manager.web.datafilter.DataFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-21 21:19:49
 */
@Service("goodsService")
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private GoodsGalleryMapper goodsGalleryMapper;


    public Goods queryObject(Integer id) {
        return goodsMapper.queryObject(id);
    }


    @DataFilter(userAlias = "nideshop_goods.create_user_id", deptAlias = "nideshop_goods.create_user_dept_id")
    public List<Goods> queryList(Map<String, Object> map) {
        return goodsMapper.queryList(map);
    }


    @DataFilter(userAlias = "nideshop_goods.create_user_id", deptAlias = "nideshop_goods.create_user_dept_id")
    public int queryTotal(Map<String, Object> map) {
        return goodsMapper.queryTotal(map);
    }


    @Transactional
    public int save(Goods goods) {
        SysUserEntity user = ShiroUtils.getUserEntity();
        Map<String, Object> map = new HashMap<>();
        map.put("name", goods.getName());
        List<Goods> list = queryList(map);
        if (null != list && list.size() != 0) {
            throw new RRException("商品名称已存在！");
        }
        Integer id = goodsMapper.queryMaxId() + 1;
        goods.setId(id);

        //保存产品信息
        Product product = new Product();
        product.setGoodsId(id);
        product.setGoodsSn(goods.getGoodsSn());
        product.setGoodsNumber(goods.getGoodsNumber());
        product.setRetailPrice(goods.getRetailPrice());
        product.setMarketPrice(goods.getMarketPrice());
        product.setGoodsSpecificationIds("");
        productMapper.save(product);

        goods.setAddTime(new Date());
        goods.setPrimaryProductId(product.getId());

        //保存商品详情页面显示的属性
        List<GoodsAttribute> attributeList = goods.getAttributeList();
        if (null != attributeList && attributeList.size() > 0) {
            for (GoodsAttribute item : attributeList) {
                item.setGoodsId(id);
                goodsAttributeMapper.save(item);
            }
        }

        //商品轮播图
        List<GoodsGallery> galleryList = goods.getGoodsImgList();
        if (null != galleryList && galleryList.size() > 0) {
            for (GoodsGallery gallery : galleryList) {
                gallery.setGoodsId(id);
                goodsGalleryMapper.save(gallery);
            }
        }

        goods.setIsDelete(0);
        goods.setCreateUserDeptId(user.getDeptId());
        goods.setCreateUserId(user.getUserId());
        goods.setUpdateUserId(user.getUserId());
        goods.setUpdateTime(new Date());
        return goodsMapper.save(goods);
    }


    @Transactional
    public int update(Goods goods) {
        SysUserEntity user = ShiroUtils.getUserEntity();
        List<GoodsAttribute> attributeList = goods.getAttributeList();
        if (null != attributeList && attributeList.size() > 0) {
            for (GoodsAttribute goodsAttribute : attributeList) {
                int result = goodsAttributeMapper.updateByGoodsIdAttributeId(goodsAttribute);
                if (result == 0) {
                    goodsAttributeMapper.save(goodsAttribute);
                }
            }
        }
        goods.setUpdateUserId(user.getUserId());
        goods.setUpdateTime(new Date());
        //商品轮播图
        //修改时全删全插
        List<GoodsGallery> galleryList = goods.getGoodsImgList();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("goodsId", goods.getId());
        goodsGalleryMapper.deleteByGoodsId(map);

        if (null != galleryList && galleryList.size() > 0) {
            for (GoodsGallery gallery : galleryList) {
                gallery.setGoodsId(goods.getId());
                goodsGalleryMapper.save(gallery);
            }
        }
        return goodsMapper.update(goods);
    }


    public int delete(Integer id) {
        SysUserEntity user = ShiroUtils.getUserEntity();
        Goods goods = queryObject(id);
        goods.setIsDelete(1);
        goods.setIsOnSale(0);
        goods.setUpdateUserId(user.getUserId());
        goods.setUpdateTime(new Date());
        return goodsMapper.update(goods);
    }


    @Transactional
    public int deleteBatch(Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result += delete(id);
        }
        return result;
    }


    @Transactional
    public int back(Integer[] ids) {
        SysUserEntity user = ShiroUtils.getUserEntity();
        int result = 0;
        for (Integer id : ids) {
            Goods goods = queryObject(id);
            goods.setIsDelete(0);
            goods.setIsOnSale(1);
            goods.setUpdateUserId(user.getUserId());
            goods.setUpdateTime(new Date());
            result += goodsMapper.update(goods);
        }
        return result;
    }


    public int enSale(Integer id) {
        SysUserEntity user = ShiroUtils.getUserEntity();
        Goods goods = queryObject(id);
        if (1 == goods.getIsOnSale()) {
            throw new RRException("此商品已处于上架状态！");
        }
        goods.setIsOnSale(1);
        goods.setUpdateUserId(user.getUserId());
        goods.setUpdateTime(new Date());
        return goodsMapper.update(goods);
    }


    public int unSale(Integer id) {
        SysUserEntity user = ShiroUtils.getUserEntity();
        Goods goods = queryObject(id);
        if (0 == goods.getIsOnSale()) {
            throw new RRException("此商品已处于下架状态！");
        }
        goods.setIsOnSale(0);
        goods.setUpdateUserId(user.getUserId());
        goods.setUpdateTime(new Date());
        return goodsMapper.update(goods);
    }
}
