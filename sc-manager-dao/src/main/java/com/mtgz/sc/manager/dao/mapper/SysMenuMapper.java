package com.mtgz.sc.manager.dao.mapper;

import com.mtgz.sc.manager.common.entity.SysMenuEntity;
import com.mtgz.sc.manager.common.entity.SysUserEntity;
import com.mtgz.sc.manager.dao.config.MyMapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by linyisheng on 2019/1/19.
 */
public interface SysMenuMapper  extends MyMapper<SysMenuEntity> {
    List<SysMenuEntity> queryList(HashMap<String, Object> stringObjectHashMap);

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();

    /**
     * 查询用户的权限列表
     */
    List<SysMenuEntity> queryUserList(Long userId);

}
