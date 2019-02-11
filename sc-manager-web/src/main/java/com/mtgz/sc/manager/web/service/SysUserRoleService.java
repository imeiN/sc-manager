package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户与角色对应关系
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年9月18日 上午9:45:48
 */
@Service("sysUserRoleService")
public class SysUserRoleService  {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        if (roleIdList.size() == 0) {
            return;
        }

        //先删除用户与角色关系
        sysUserRoleMapper.delete(userId);

        //保存用户与角色关系
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("roleIdList", roleIdList);
        sysUserRoleMapper.save(map);
    }

    
    public List<Long> queryRoleIdList(Long userId) {
        return sysUserRoleMapper.queryRoleIdList(userId);
    }

    
    public void delete(Long userId) {
        sysUserRoleMapper.delete(userId);
    }
}
