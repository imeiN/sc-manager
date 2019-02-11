package com.mtgz.sc.manager.dao.mapper;


import com.mtgz.sc.manager.common.entity.SysRoleEntity;
import com.mtgz.sc.manager.common.entity.UserWindowDto;
import com.mtgz.sc.manager.dao.config.MyMapper;

import java.util.List;

/**
 * 角色管理
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年9月18日 上午9:33:33
 */
public interface SysRoleMapper extends MyMapper<SysRoleEntity> {

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);

    /**
     * 查询角色审批选择范围
     * @return
     */
    List<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto);
}
