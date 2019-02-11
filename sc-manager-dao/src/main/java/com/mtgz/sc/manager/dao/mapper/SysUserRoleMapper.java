package com.mtgz.sc.manager.dao.mapper;

import com.mtgz.sc.manager.common.entity.SysUserRoleEntity;
import com.mtgz.sc.manager.dao.config.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年9月18日 上午9:34:46
 */
public interface SysUserRoleMapper extends MyMapper<SysUserRoleEntity> {

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);

    void save(Map<String, Object> map);
}
