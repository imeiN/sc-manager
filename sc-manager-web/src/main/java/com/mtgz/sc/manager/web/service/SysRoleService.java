package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.common.constants.Constant;
import com.mtgz.sc.manager.common.entity.SysRoleEntity;
import com.mtgz.sc.manager.common.entity.UserWindowDto;
import com.mtgz.sc.manager.common.page.Page;
import com.mtgz.sc.manager.common.page.PageHelper;
import com.mtgz.sc.manager.common.util.RRException;
import com.mtgz.sc.manager.dao.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 角色
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年9月18日 上午9:45:12
 */
@Service("sysRoleService")
public class SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    
    public SysRoleEntity queryObject(Long roleId) {
        return sysRoleMapper.queryObject(roleId);
    }

    
    public List<SysRoleEntity> queryList(Map<String, Object> map) {
        return sysRoleMapper.queryList(map);
    }

    
    public int queryTotal(Map<String, Object> map) {
        return sysRoleMapper.queryTotal(map);
    }

    
    @Transactional
    public void save(SysRoleEntity role) {
        role.setCreateTime(new Date());
        sysRoleMapper.save(role);

        //检查权限是否越权
        checkPrems(role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
    }

    
    @Transactional
    public void update(SysRoleEntity role) {
        sysRoleMapper.update(role);

        //检查权限是否越权
        checkPrems(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
    }

    
    @Transactional
    public void deleteBatch(Long[] roleIds) {
        sysRoleMapper.deleteBatch(roleIds);
    }

    
    public List<Long> queryRoleIdList(Long createUserId) {
        return sysRoleMapper.queryRoleIdList(createUserId);
    }

    /**
     * 检查权限是否越权
     */
    private void checkPrems(SysRoleEntity role) {
        //如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
        if (role.getCreateUserId() == Constant.SUPER_ADMIN) {
            return;
        }

        //查询用户所拥有的菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());

        //判断是否越权
        if (!menuIdList.containsAll(role.getMenuIdList())) {
            throw new RRException("新增角色的权限，已超出你的权限范围");
        }
    }

    
    public Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNum) {
        PageHelper.startPage(pageNum, Constant.pageSize);
        sysRoleMapper.queryPageByDto(userWindowDto);
        return PageHelper.endPage();
    }
}
