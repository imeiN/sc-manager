package com.mtgz.sc.manager.web.service;

import com.alibaba.fastjson.JSON;
import com.mtgz.sc.manager.common.entity.SysConfigEntity;
import com.mtgz.sc.manager.common.util.RRException;
import com.mtgz.sc.manager.dao.mapper.SysConfigMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sysConfigService")
public class SysConfigService {
	@Autowired
	private SysConfigMapper sysConfigMapper;
	
	
	public void save(SysConfigEntity config) {
		sysConfigMapper.save(config);
	}

	
	public void update(SysConfigEntity config) {
		sysConfigMapper.update(config);
	}

	
	public void updateValueByKey(String key, String value) {
		sysConfigMapper.updateValueByKey(key, value);
	}

	
	public void deleteBatch(Long[] ids) {
		sysConfigMapper.deleteBatch(ids);
	}

	
	public List<SysConfigEntity> queryList(Map<String, Object> map) {
		return sysConfigMapper.queryList(map);
	}

	
	public int queryTotal(Map<String, Object> map) {
		return sysConfigMapper.queryTotal(map);
	}

	
	public SysConfigEntity queryObject(Long id) {
		return sysConfigMapper.queryObject(id);
	}

	
	public String getValue(String key, String defaultValue) {
		String value = sysConfigMapper.queryByKey(key);
		if(StringUtils.isBlank(value)){
			return defaultValue;
		}
		return value;
	}
	
	
	public <T> T getConfigObject(String key, Class<T> clazz) {
		String value = getValue(key, null);
		if(StringUtils.isNotBlank(value)){
			return JSON.parseObject(value, clazz);
		}

		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new RRException("获取参数失败");
		}
	}
}
