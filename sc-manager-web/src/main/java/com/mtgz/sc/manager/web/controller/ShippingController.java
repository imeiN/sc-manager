package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.Shipping;
import com.mtgz.sc.manager.web.service.ShippingService;
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
 * @date 2017-09-04 21:42:24
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "shipping")
public class ShippingController {
    @Autowired
    private ShippingService shippingService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("shipping:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<Shipping> shippingList = shippingService.queryList(query);
        int total = shippingService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(shippingList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("shipping:info")
    public R info(@PathVariable("id") Integer id) {
        Shipping shipping = shippingService.queryObject(id);

        return R.ok().put("shipping", shipping);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("shipping:save")
    public R save(@RequestBody Shipping shipping) {
        shippingService.save(shipping);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("shipping:update")
    public R update(@RequestBody Shipping shipping) {
        shippingService.update(shipping);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("shipping:delete")
    public R delete(@RequestBody Integer[] ids) {
        shippingService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<Shipping> list = shippingService.queryList(params);

        return R.ok().put("list", list);
    }
}
