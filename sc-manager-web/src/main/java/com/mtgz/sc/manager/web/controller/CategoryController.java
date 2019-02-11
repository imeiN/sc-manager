package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.common.util.TreeUtils;
import com.mtgz.sc.manager.dao.model.Category;
import com.mtgz.sc.manager.web.service.CategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-21 15:32:31
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("category:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<Category> categoryList = categoryService.queryList(query);
        int total = categoryService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(categoryList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("category:info")
    public R info(@PathVariable("id") Integer id) {
        Category category = categoryService.queryObject(id);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("category:save")
    public R save(@RequestBody Category category) {
        categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("category:update")
    public R update(@RequestBody Category category) {
        categoryService.update(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("category:delete")
    public R delete(@RequestBody Integer[] ids) {
        categoryService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<Category> list = categoryService.queryList(params);
        //添加顶级菜单
        Category root = new Category();
        root.setId(0);
        root.setName("一级分类");
        root.setParentId(-1);
        root.setOpen(true);
        list.add(0,root);
        return R.ok().put("list", list);
    }

    /**
     * 查看信息(全部加载页面渲染太慢！)
     */
    @RequestMapping("/getAreaTree")
    public R getAreaTree() {
        List<Category> list = categoryService.queryList(new HashMap<String, Object>());
        for (Category sysRegion : list) {
            sysRegion.setValue(sysRegion.getId() + "");
            sysRegion.setLabel(sysRegion.getName());
        }
        List<Category> node = TreeUtils.factorTree(list);

        return R.ok().put("node", node);
    }

    /**
     * 查询
     *
     * @return
     */
    @RequestMapping("/getCategorySelect")
    public R getCategorySelect() {
        Map<String, Object> map = new HashMap<>();
        map.put("parentId", "0");
        List<Category> list = categoryService.queryList(map);
        return R.ok().put("list", list);
    }
}
