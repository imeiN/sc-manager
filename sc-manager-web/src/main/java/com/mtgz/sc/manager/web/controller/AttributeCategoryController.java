package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.AttributeCategory;
import com.mtgz.sc.manager.web.service.AttributeCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-17 16:13:27
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "attributecategory")
public class AttributeCategoryController {
    @Autowired
    private AttributeCategoryService attributeCategoryService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("attributecategory:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<AttributeCategory> attributeCategoryList = attributeCategoryService.queryList(query);
        int total = attributeCategoryService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(attributeCategoryList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("attributecategory:info")
    public R info(@PathVariable("id") Integer id) {
        AttributeCategory attributeCategory = attributeCategoryService.queryObject(id);

        return R.ok().put("attributeCategory", attributeCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("attributecategory:save")
    public R save(@RequestBody AttributeCategory attributeCategory) {
        attributeCategoryService.save(attributeCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("attributecategory:update")
    public R update(@RequestBody AttributeCategory attributeCategory) {
        attributeCategoryService.update(attributeCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("attributecategory:delete")
    public R delete(@RequestBody Integer[] ids) {
        attributeCategoryService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<AttributeCategory> list = attributeCategoryService.queryList(params);

        return R.ok().put("list", list);
    }
}
