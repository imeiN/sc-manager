package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.Address;
import com.mtgz.sc.manager.web.service.AddressService;
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
 * @date 2017-08-16 17:22:46
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("address:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<Address> addressList = addressService.queryList(query);
        int total = addressService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("address:info")
    public R info(@PathVariable("id") Integer id) {
        Address address = addressService.queryObject(id);

        return R.ok().put("address", address);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("address:save")
    public R save(@RequestBody Address address) {
        addressService.save(address);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("address:update")
    public R update(@RequestBody Address address) {
        addressService.update(address);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("address:delete")
    public R delete(@RequestBody Integer[] ids) {
        addressService.deleteBatch(ids);

        return R.ok();
    }
}
