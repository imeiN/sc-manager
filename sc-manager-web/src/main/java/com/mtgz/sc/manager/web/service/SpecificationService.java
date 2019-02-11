package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.SpecificationMapper;
import com.mtgz.sc.manager.dao.model.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("specificationService")
public class SpecificationService {
	@Autowired
	private SpecificationMapper specificationMapper;
	

	public Specification queryObject(Integer id){
		return specificationMapper.queryObject(id);
	}
	

	public List<Specification> queryList(Map<String, Object> map){
		return specificationMapper.queryList(map);
	}
	

	public int queryTotal(Map<String, Object> map){
		return specificationMapper.queryTotal(map);
	}
	

	public void save(Specification specification){
		specificationMapper.save(specification);
	}
	

	public void update(Specification specification){
		specificationMapper.update(specification);
	}
	

	public void delete(Integer id){
		specificationMapper.delete(id);
	}
	

	public void deleteBatch(Integer[] ids){
		specificationMapper.deleteBatch(ids);
	}
	
}
