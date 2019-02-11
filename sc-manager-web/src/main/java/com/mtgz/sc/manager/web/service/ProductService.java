package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.common.util.BeanUtils;
import com.mtgz.sc.manager.common.util.StringUtils;
import com.mtgz.sc.manager.dao.mapper.GoodsSpecificationMapper;
import com.mtgz.sc.manager.dao.mapper.ProductMapper;
import com.mtgz.sc.manager.dao.model.GoodsSpecification;
import com.mtgz.sc.manager.dao.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-30 14:31:21
 */
@Service("productService")
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;


    public Product queryObject(Integer id) {
        return productMapper.queryObject(id);
    }


    public List<Product> queryList(Map<String, Object> map) {
        List<Product> list = productMapper.queryList(map);

        List<Product> result = new ArrayList<>();
        //翻译产品规格
        if (null != list && list.size() > 0) {
            for (Product item : list) {
                String specificationIds = item.getGoodsSpecificationIds();
                String specificationValue = "";
                if (!StringUtils.isNullOrEmpty(specificationIds)) {
                    String[] arr = specificationIds.split("_");

                    for (String goodsSpecificationId : arr) {
                        GoodsSpecification entity = goodsSpecificationMapper.queryObject(goodsSpecificationId);
                        if (null != entity) {
                            specificationValue += entity.getValue() + "；";
                        }
                    }
                }
                item.setSpecificationValue(item.getGoodsName() + " " + specificationValue);
                result.add(item);
            }
        }
        return result;
    }


    public int queryTotal(Map<String, Object> map) {
        return productMapper.queryTotal(map);
    }


    @Transactional
    public int save(Product product) {
        int result = 0;
        String goodsSpecificationIds = product.getGoodsSpecificationIds();
        if (!StringUtils.isNullOrEmpty(goodsSpecificationIds)) {
            String[] goodsSpecificationIdArr = goodsSpecificationIds.split("_");
            for (int i = 0; i < goodsSpecificationIdArr.length - 1; i++) {
                String[] oneId = goodsSpecificationIdArr[i].split(",");
                String[] twoId = goodsSpecificationIdArr[i + 1].split(",");
                for (int j = 0; j < oneId.length; j++) {
                    for (int k = 0; k < twoId.length; k++) {
                        String strGoodsSpecificationIds = null;
                        if (StringUtils.isNullOrEmpty(oneId[j]) || StringUtils.isNullOrEmpty(twoId[k])){
                            continue;
                        }
                        strGoodsSpecificationIds = oneId[j] + "_" + twoId[k];
                        product.setGoodsSpecificationIds(strGoodsSpecificationIds);
                        Product entity = new Product();
                        BeanUtils.copyProperties(product, entity);
                        result += productMapper.save(entity);
                    }
                }
            }
        }
        return result;
    }


    public int update(Product product) {
        if (StringUtils.isNullOrEmpty(product.getGoodsSpecificationIds())){
            product.setGoodsSpecificationIds("");
        }
        return productMapper.update(product);
    }


    public int delete(Integer id) {
        return productMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return productMapper.deleteBatch(ids);
    }
}
