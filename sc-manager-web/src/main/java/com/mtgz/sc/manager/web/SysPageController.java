package com.mtgz.sc.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年11月24日 下午11:05:27
 */
@Controller
public class SysPageController {

    /**
     * 视图路径
     *
     * @param module 模块
     * @param url    url
     * @return 页面视图路径
     */
    @RequestMapping("{module}/{url}.html")
    public String page(@PathVariable("module") String module, @PathVariable("url") String url) {
        return module + "/" + url;
    }

    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

}
