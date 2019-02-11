package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.CartMapper;
import com.mtgz.sc.manager.dao.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("cartService")
public class CartService {

	@Autowired
	private CartMapper cartMapper;
	

	public Cart queryObject(Integer id){
		return cartMapper.queryObject(id);
	}
	

	public List<Cart> queryList(Map<String, Object> map){
		return cartMapper.queryList(map);
	}
	

	public int queryTotal(Map<String, Object> map){
		return cartMapper.queryTotal(map);
	}
	

	public void save(Cart cart){
		cartMapper.save(cart);
	}
	

	public void update(Cart cart){
		cartMapper.update(cart);
	}
	

	public void delete(Integer id){
		cartMapper.delete(id);
	}
	

	public void deleteBatch(Integer[] ids){
		cartMapper.deleteBatch(ids);
	}
	
}
