package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.GoodsSpecification;
import com.mtgz.sc.manager.web.service.GoodsSpecificationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品对应规格表值表Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-31 11:15:55
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "goodsspecification")
public class GoodsSpecificationController {
    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("goodsspecification:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<GoodsSpecification> goodsSpecificationList = goodsSpecificationService.queryList(query);
        int total = goodsSpecificationService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(goodsSpecificationList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("goodsspecification:info")
    public R info(@PathVariable("id") Integer id) {
        GoodsSpecification goodsSpecification = goodsSpecificationService.queryObject(id);

        return R.ok().put("goodsSpecification", goodsSpecification);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("goodsspecification:save")
    public R save(@RequestBody GoodsSpecification goodsSpecification) {
        goodsSpecificationService.save(goodsSpecification);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("goodsspecification:update")
    public R update(@RequestBody GoodsSpecification goodsSpecification) {
        goodsSpecificationService.update(goodsSpecification);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("goodsspecification:delete")
    public R delete(@RequestBody Integer[]ids) {
        goodsSpecificationService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<GoodsSpecification> list = goodsSpecificationService.queryList(params);

        return R.ok().put("list", list);
    }
}
