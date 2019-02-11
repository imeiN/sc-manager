package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.RelatedGoodsMapper;
import com.mtgz.sc.manager.dao.model.RelatedGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("relatedGoodsService")
public class RelatedGoodsService {
	@Autowired
	private RelatedGoodsMapper relatedGoodsMapper;
	

	public RelatedGoods queryObject(Integer id){
		return relatedGoodsMapper.queryObject(id);
	}
	

	public List<RelatedGoods> queryList(Map<String, Object> map){
		return relatedGoodsMapper.queryList(map);
	}
	

	public int queryTotal(Map<String, Object> map){
		return relatedGoodsMapper.queryTotal(map);
	}
	

	public void save(RelatedGoods relatedGoods){
		relatedGoodsMapper.save(relatedGoods);
	}
	

	public void update(RelatedGoods relatedGoods){
		relatedGoodsMapper.update(relatedGoods);
	}
	

	public void delete(Integer id){
		relatedGoodsMapper.delete(id);
	}
	

	public void deleteBatch(Integer[] ids){
		relatedGoodsMapper.deleteBatch(ids);
	}
	
}
