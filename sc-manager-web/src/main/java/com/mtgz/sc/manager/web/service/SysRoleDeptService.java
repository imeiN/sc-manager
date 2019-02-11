package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.SysRoleDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 角色与部门对应关系
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017年9月18日 上午9:18:38
 */
@Service("sysRoleDeptService")
public class SysRoleDeptService {
    @Autowired
    private SysRoleDeptMapper sysRoleDeptMapper;

    
    @Transactional
    public void saveOrUpdate(Long roleId, List<Long> deptIdList) {
        //先删除角色与菜单关系
        sysRoleDeptMapper.delete(roleId);

        if (deptIdList.size() == 0) {
            return;
        }

        //保存角色与菜单关系
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("deptIdList", deptIdList);
        sysRoleDeptMapper.save(map);
    }

    
    public List<Long> queryDeptIdList(Long roleId) {
        return sysRoleDeptMapper.queryDeptIdList(roleId);
    }

    
    public List<Long> queryDeptIdListByUserId(Long userId) {
        return sysRoleDeptMapper.queryDeptIdListByUserId(userId);
    }
}
