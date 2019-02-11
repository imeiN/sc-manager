package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.Ad;
import com.mtgz.sc.manager.web.service.AdService;
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
 * @date 2017-08-19 09:37:35
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "ad")
public class AdController {
    @Autowired
    private AdService adService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("ad:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<Ad> adList = adService.queryList(query);
        int total = adService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(adList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ad:info")
    public R info(@PathVariable("id") Integer id) {
        Ad ad = adService.queryObject(id);

        return R.ok().put("ad", ad);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ad:save")
    public R save(@RequestBody Ad ad) {
        adService.save(ad);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ad:update")
    public R update(@RequestBody Ad ad) {
        adService.update(ad);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ad:delete")
    public R delete(@RequestBody Integer[] ids) {
        adService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<Ad> list = adService.queryList(params);

        return R.ok().put("list", list);
    }
}
