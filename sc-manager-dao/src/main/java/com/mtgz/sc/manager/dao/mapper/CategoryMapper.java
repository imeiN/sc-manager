package com.mtgz.sc.manager.dao.mapper;

import com.mtgz.sc.manager.dao.config.MyMapper;
import com.mtgz.sc.manager.dao.model.Category;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper extends MyMapper<Category> {
    void deleteByParentBatch(@Param("ids") Integer[] ids);
}