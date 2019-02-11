package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.Collect;
import com.mtgz.sc.manager.web.service.CollectService;
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
@RequestMapping(value = AppConstants.BASE_PATH + "collect")
public class CollectController {
	@Autowired
	private CollectService collectService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("collect:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Collect> collectList = collectService.queryList(query);
		int total = collectService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(collectList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("collect:info")
	public R info(@PathVariable("id") Integer id){
		Collect collect = collectService.queryObject(id);
		
		return R.ok().put("collect", collect);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("collect:save")
	public R save(@RequestBody Collect collect){
		collectService.save(collect);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("collect:update")
	public R update(@RequestBody Collect collect){
		collectService.update(collect);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("collect:delete")
	public R delete(@RequestBody Integer[] ids){
		collectService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
