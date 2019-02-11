package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.AttributeMapper;
import com.mtgz.sc.manager.dao.model.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("attributeService")
public class AttributeService  {
	@Autowired
	private AttributeMapper attributeMapper;
	
	
	public Attribute queryObject(Integer id){
		return attributeMapper.queryObject(id);
	}
	
	
	public List<Attribute> queryList(Map<String, Object> map){
		return attributeMapper.queryList(map);
	}
	
	
	public int queryTotal(Map<String, Object> map){
		return attributeMapper.queryTotal(map);
	}
	
	
	public void save(Attribute attribute){
		attributeMapper.save(attribute);
	}
	
	
	public void update(Attribute attribute){
		attributeMapper.update(attribute);
	}
	
	
	public void delete(Integer id){
		attributeMapper.delete(id);
	}
	
	
	public void deleteBatch(Integer[] ids){
		attributeMapper.deleteBatch(ids);
	}
	
}
