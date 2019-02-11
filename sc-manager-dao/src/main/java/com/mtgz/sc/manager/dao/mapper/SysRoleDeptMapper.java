package com.mtgz.sc.manager.dao.mapper;

import com.mtgz.sc.manager.common.entity.SysRoleDeptEntity;
import com.mtgz.sc.manager.dao.config.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 角色与部门对应关系
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017年9月18日 上午9:18:38
 */
@Mapper
public interface SysRoleDeptMapper extends MyMapper<SysRoleDeptEntity> {

    /**
     * 根据角色ID，获取部门ID列表
     */
    List<Long> queryDeptIdList(Long roleId);

    /**
     * 根据用户ID获取权限部门列表
     *
     * @param userId
     * @return
     */
    List<Long> queryDeptIdListByUserId(Long userId);

    void save(Map<String, Object> map);
}
