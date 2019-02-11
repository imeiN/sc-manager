package com.mtgz.sc.manager.dao.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

    T queryObject(Object obj);

    List<T> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    default int deleteBatch(Object[] ids) {
        int rows = 0;
        if (null != ids && ids.length > 0) {
            for (Object id: ids) {
                rows += deleteByPrimaryKey(id);
            }
        }
        return rows;
    }

    default int delete(Integer id){
        return deleteByPrimaryKey(id);
    }

    default int delete(Long id){
        return deleteByPrimaryKey(id);
    }

    default int save(T t){
        return insert(t);
    }

    default int update(T t){
        return updateByPrimaryKey(t);
    }
}
