package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.Cart;
import com.mtgz.sc.manager.web.service.CartService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-13 10:41:06
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("cart:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Cart> cartList = cartService.queryList(query);
		int total = cartService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(cartList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("cart:info")
	public R info(@PathVariable("id") Integer id){
		Cart cart = cartService.queryObject(id);
		
		return R.ok().put("cart", cart);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("cart:save")
	public R save(@RequestBody Cart cart){
		cartService.save(cart);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("cart:update")
	public R update(@RequestBody Cart cart){
		cartService.update(cart);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("cart:delete")
	public R delete(@RequestBody Integer[] ids){
		cartService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
