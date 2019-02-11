package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.FootprintMapper;
import com.mtgz.sc.manager.dao.model.Footprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("footprintService")
public class FootprintService {
	@Autowired
	private FootprintMapper footprintMapper;
	

	public Footprint queryObject(Integer id){
		return footprintMapper.queryObject(id);
	}
	

	public List<Footprint> queryList(Map<String, Object> map){
		return footprintMapper.queryList(map);
	}
	

	public int queryTotal(Map<String, Object> map){
		return footprintMapper.queryTotal(map);
	}
	

	public void save(Footprint footprint){
		footprintMapper.save(footprint);
	}
	

	public void update(Footprint footprint){
		footprintMapper.update(footprint);
	}
	

	public void delete(Integer id){
		footprintMapper.delete(id);
	}
	

	public void deleteBatch(Integer[] ids){
		footprintMapper.deleteBatch(ids);
	}
	
}
