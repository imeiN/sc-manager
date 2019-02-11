package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.UserCoupon;
import com.mtgz.sc.manager.web.service.UserCouponService;
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
 * @date 2017-08-19 15:40:33
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "usercoupon")
public class UserCouponController {
    @Autowired
    private UserCouponService userCouponService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("usercoupon:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<UserCoupon> userCouponList = userCouponService.queryList(query);
        int total = userCouponService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(userCouponList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("usercoupon:info")
    public R info(@PathVariable("id") Integer id) {
        UserCoupon userCoupon = userCouponService.queryObject(id);

        return R.ok().put("userCoupon", userCoupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("usercoupon:save")
    public R save(@RequestBody UserCoupon userCoupon) {
        userCouponService.save(userCoupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("usercoupon:update")
    public R update(@RequestBody UserCoupon userCoupon) {
        userCouponService.update(userCoupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("usercoupon:delete")
    public R delete(@RequestBody Integer[] ids) {
        userCouponService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<UserCoupon> list = userCouponService.queryList(params);

        return R.ok().put("list", list);
    }
}
