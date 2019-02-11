package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.GoodsAttributeMapper;
import com.mtgz.sc.manager.dao.model.GoodsAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("goodsAttributeService")
public class GoodsAttributeService {
	@Autowired
	private GoodsAttributeMapper goodsAttributeMapper;
	

	public GoodsAttribute queryObject(Integer id){
		return goodsAttributeMapper.queryObject(id);
	}
	

	public List<GoodsAttribute> queryList(Map<String, Object> map){
		return goodsAttributeMapper.queryList(map);
	}
	

	public int queryTotal(Map<String, Object> map){
		return goodsAttributeMapper.queryTotal(map);
	}
	

	public void save(GoodsAttribute goodsAttribute){
		goodsAttributeMapper.save(goodsAttribute);
	}
	

	public void update(GoodsAttribute goodsAttribute){
		goodsAttributeMapper.update(goodsAttribute);
	}
	

	public void delete(Integer id){
		goodsAttributeMapper.delete(id);
	}
	

	public void deleteBatch(Integer[] ids){
		goodsAttributeMapper.deleteBatch(ids);
	}
	
}
