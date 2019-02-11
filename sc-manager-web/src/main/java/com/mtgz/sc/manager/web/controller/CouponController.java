package com.mtgz.sc.manager.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.Coupon;
import com.mtgz.sc.manager.web.service.CouponService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 优惠券Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-19 12:53:26
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("coupon:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<Coupon> couponList = couponService.queryList(query);
        PageUtils pageUtil = new PageUtils(new PageInfo(couponList));

        return R.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("coupon:info")
    public R info(@PathVariable("id") Integer id) {
        Coupon coupon = couponService.queryObject(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("coupon:save")
    public R save(@RequestBody Coupon coupon) {
        couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("coupon:update")
    public R update(@RequestBody Coupon coupon) {
        couponService.update(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("coupon:delete")
    public R delete(@RequestBody Integer[] ids) {
        couponService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<Coupon> list = couponService.queryList(params);

        return R.ok().put("list", list);
    }

    /**
     * 按用户、商品下发优惠券
     *
     * @param params
     * @return
     */
    @RequiresPermissions("coupon:publish")
    @RequestMapping(value = "publish", method = RequestMethod.POST)
    public R publish(@RequestBody Map<String, Object> params) {
        return couponService.publish(params);
    }
}
