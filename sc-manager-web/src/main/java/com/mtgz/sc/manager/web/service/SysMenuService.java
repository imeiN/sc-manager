package com.mtgz.sc.manager.web.service;


import com.mtgz.sc.manager.common.constants.Constant;
import com.mtgz.sc.manager.common.entity.SysMenuEntity;
import com.mtgz.sc.manager.dao.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("sysMenuService")
public class SysMenuService {
	@Autowired
	private SysMenuMapper sysMenuMapper;
	@Autowired
	private SysUserService userService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	
	
	public List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
		List<SysMenuEntity> menuList = sysMenuMapper.queryListParentId(parentId);
		if(menuIdList == null){
			return menuList;
		}
		
		List<SysMenuEntity> userMenuList = new ArrayList<>();
		for(SysMenuEntity menu : menuList){
			if(menuIdList.contains(menu.getMenuId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	
	public List<SysMenuEntity> queryNotButtonList() {
		return sysMenuMapper.queryNotButtonList();
	}

	
	public List<SysMenuEntity> getUserMenuList(Long userId) {
		//系统管理员，拥有最高权限
		if(userId == 1){
			return getAllMenuList(null);
		}
		
		//用户菜单列表
		List<Long> menuIdList = userService.queryAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}
	
	
	public SysMenuEntity queryObject(Long menuId) {
		return sysMenuMapper.queryObject(menuId);
	}

	
	public List<SysMenuEntity> queryList(Map<String, Object> map) {
		return sysMenuMapper.queryList(map);
	}

	
	public int queryTotal(Map<String, Object> map) {
		return sysMenuMapper.queryTotal(map);
	}

	
	public void save(SysMenuEntity menu) {
		sysMenuMapper.save(menu);
	}

	
	public void update(SysMenuEntity menu) {
		sysMenuMapper.update(menu);
	}

	
	@Transactional
	public void deleteBatch(Long[] menuIds) {
		sysMenuMapper.deleteBatch(menuIds);
	}
	
	
	public List<SysMenuEntity> queryUserList(Long userId) {
		return sysMenuMapper.queryUserList(userId);
	}

	/**
	 * 获取所有菜单列表
	 */
	private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList){
		//查询根菜单列表
		List<SysMenuEntity> menuList = queryListParentId(0L, menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		
		return menuList;
	}

	/**
	 * 递归
	 */
	private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Long> menuIdList){
		List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();
		
		for(SysMenuEntity entity : menuList){
			if(entity.getType() == Constant.MenuType.CATALOG.getValue()){//目录
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}
		
		return subMenuList;
	}
}
