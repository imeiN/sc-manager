package com.mtgz.sc.manager.dao.mapper;

import com.mtgz.sc.manager.common.entity.SysUserEntity;
import com.mtgz.sc.manager.common.entity.UserWindowDto;
import com.mtgz.sc.manager.dao.config.MyMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by linyisheng on 2019/1/19.
 */
public interface SysUserMapper extends MyMapper<SysUserEntity> {

    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);

    /**
     * 修改密码
     */
    int updatePassword(Map<String, Object> map);
    /**
     * 根据实体类查询
     * @param userWindowDto
     * @return
     */
    List<UserWindowDto> queryListByBean(UserWindowDto userWindowDto);
}
