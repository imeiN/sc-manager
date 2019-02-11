package com.mtgz.sc.manager.web.controller;

import com.mtgz.sc.manager.common.AppConstants;
import com.mtgz.sc.manager.common.util.PageUtils;
import com.mtgz.sc.manager.common.util.Query;
import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.model.Topic;
import com.mtgz.sc.manager.web.service.TopicService;
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
 * @date 2017-08-20 14:10:08
 */
@RestController
@RequestMapping(value = AppConstants.BASE_PATH + "topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("topic:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<Topic> topicList = topicService.queryList(query);
        int total = topicService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(topicList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("topic:info")
    public R info(@PathVariable("id") Integer id) {
        Topic topic = topicService.queryObject(id);

        return R.ok().put("topic", topic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("topic:save")
    public R save(@RequestBody Topic topic) {
        topicService.save(topic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("topic:update")
    public R update(@RequestBody Topic topic) {
        topicService.update(topic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("topic:delete")
    public R delete(@RequestBody Integer[] ids) {
        topicService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<Topic> list = topicService.queryList(params);

        return R.ok().put("list", list);
    }
}
