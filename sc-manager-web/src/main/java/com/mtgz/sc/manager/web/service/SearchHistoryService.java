package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.SearchHistoryMapper;
import com.mtgz.sc.manager.dao.model.SearchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("searchHistoryService")
public class SearchHistoryService {
	@Autowired
	private SearchHistoryMapper searchHistoryMapper;
	

	public SearchHistory queryObject(Integer id){
		return searchHistoryMapper.queryObject(id);
	}
	

	public List<SearchHistory> queryList(Map<String, Object> map){
		return searchHistoryMapper.queryList(map);
	}
	

	public int queryTotal(Map<String, Object> map){
		return searchHistoryMapper.queryTotal(map);
	}
	

	public void save(SearchHistory searchHistory){
		searchHistoryMapper.save(searchHistory);
	}
	

	public void update(SearchHistory searchHistory){
		searchHistoryMapper.update(searchHistory);
	}
	

	public void delete(Integer id){
		searchHistoryMapper.delete(id);
	}
	

	public void deleteBatch(Integer[] ids){
		searchHistoryMapper.deleteBatch(ids);
	}
	
}
