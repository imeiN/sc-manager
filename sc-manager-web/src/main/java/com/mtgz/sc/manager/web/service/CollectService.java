package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.CollectMapper;
import com.mtgz.sc.manager.dao.model.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("collectService")
public class CollectService {
	@Autowired
	private CollectMapper collectMapper;
	

	public Collect queryObject(Integer id){
		return collectMapper.queryObject(id);
	}
	

	public List<Collect> queryList(Map<String, Object> map){
		return collectMapper.queryList(map);
	}
	

	public int queryTotal(Map<String, Object> map){
		return collectMapper.queryTotal(map);
	}
	

	public void save(Collect collect){
		collectMapper.save(collect);
	}
	

	public void update(Collect collect){
		collectMapper.update(collect);
	}
	

	public void delete(Integer id){
		collectMapper.delete(id);
	}
	

	public void deleteBatch(Integer[] ids){
		collectMapper.deleteBatch(ids);
	}
	
}
