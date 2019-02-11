package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.CouponGoods;
import com.mtgz.sc.manager.web.service.CouponGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 优惠券关联商品Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-29 21:50:17
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "coupongoods")
public class CouponGoodsController {
    @Autowired
    private CouponGoodsService couponGoodsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("coupongoods:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<CouponGoods> couponGoodsList = couponGoodsService.queryList(query);
        int total = couponGoodsService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(couponGoodsList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("coupongoods:info")
    public R info(@PathVariable("id") Integer id) {
        CouponGoods couponGoods = couponGoodsService.queryObject(id);

        return R.ok().put("couponGoods", couponGoods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("coupongoods:save")
    public R save(@RequestBody CouponGoods couponGoods) {
        couponGoodsService.save(couponGoods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("coupongoods:update")
    public R update(@RequestBody CouponGoods couponGoods) {
        couponGoodsService.update(couponGoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("coupongoods:delete")
    public R delete(@RequestBody Integer[]ids) {
        couponGoodsService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<CouponGoods> list = couponGoodsService.queryList(params);

        return R.ok().put("list", list);
    }
}
