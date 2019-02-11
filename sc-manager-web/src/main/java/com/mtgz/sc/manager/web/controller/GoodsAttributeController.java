package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.GoodsAttribute;
import com.mtgz.sc.manager.web.service.GoodsAttributeService;
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
 * @date 2017-08-13 10:41:08
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "goodsattribute")
public class GoodsAttributeController {
	@Autowired
	private GoodsAttributeService goodsAttributeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("goodsattribute:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GoodsAttribute> goodsAttributeList = goodsAttributeService.queryList(query);
		int total = goodsAttributeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(goodsAttributeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("goodsattribute:info")
	public R info(@PathVariable("id") Integer id){
		GoodsAttribute goodsAttribute = goodsAttributeService.queryObject(id);
		
		return R.ok().put("goodsAttribute", goodsAttribute);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("goodsattribute:save")
	public R save(@RequestBody GoodsAttribute goodsAttribute){
		goodsAttributeService.save(goodsAttribute);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("goodsattribute:update")
	public R update(@RequestBody GoodsAttribute goodsAttribute){
		goodsAttributeService.update(goodsAttribute);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("goodsattribute:delete")
	public R delete(@RequestBody Integer[] ids){
		goodsAttributeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
