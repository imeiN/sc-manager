package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.OrderGoodsMapper;
import com.mtgz.sc.manager.dao.model.OrderGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("orderGoodsService")
public class OrderGoodsService {
	@Autowired
	private OrderGoodsMapper orderGoodsMapper;
	

	public OrderGoods queryObject(Integer id){
		return orderGoodsMapper.queryObject(id);
	}
	

	public List<OrderGoods> queryList(Map<String, Object> map){
		return orderGoodsMapper.queryList(map);
	}
	

	public int queryTotal(Map<String, Object> map){
		return orderGoodsMapper.queryTotal(map);
	}
	

	public void save(OrderGoods orderGoods){
		orderGoodsMapper.save(orderGoods);
	}
	

	public void update(OrderGoods orderGoods){
		orderGoodsMapper.update(orderGoods);
	}
	

	public void delete(Integer id){
		orderGoodsMapper.delete(id);
	}
	

	public void deleteBatch(Integer[] ids){
		orderGoodsMapper.deleteBatch(ids);
	}
	
}
