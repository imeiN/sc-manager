package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.RelatedGoods;
import com.mtgz.sc.manager.web.service.RelatedGoodsService;
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
 * @date 2017-08-13 10:41:09
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "relatedgoods")
public class RelatedGoodsController {
	@Autowired
	private RelatedGoodsService relatedGoodsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("relatedgoods:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<RelatedGoods> relatedGoodsList = relatedGoodsService.queryList(query);
		int total = relatedGoodsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(relatedGoodsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("relatedgoods:info")
	public R info(@PathVariable("id") Integer id){
		RelatedGoods relatedGoods = relatedGoodsService.queryObject(id);
		
		return R.ok().put("relatedGoods", relatedGoods);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("relatedgoods:save")
	public R save(@RequestBody RelatedGoods relatedGoods){
		relatedGoodsService.save(relatedGoods);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("relatedgoods:update")
	public R update(@RequestBody RelatedGoods relatedGoods){
		relatedGoodsService.update(relatedGoods);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("relatedgoods:delete")
	public R delete(@RequestBody Integer[] ids){
		relatedGoodsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
