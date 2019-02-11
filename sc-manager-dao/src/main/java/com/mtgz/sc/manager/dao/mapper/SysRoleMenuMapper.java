package com.mtgz.sc.manager.dao.mapper;


import com.mtgz.sc.manager.common.entity.SysRoleMenuEntity;
import com.mtgz.sc.manager.dao.config.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年9月18日 上午9:33:46
 */
public interface SysRoleMenuMapper extends MyMapper<SysRoleMenuEntity> {

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> queryMenuIdList(Long roleId);

    void save(Map<String, Object> map);
}
