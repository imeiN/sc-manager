package com.mtgz.sc.manager.dao.mapper;

import com.mtgz.sc.manager.common.entity.SysConfigEntity;
import com.mtgz.sc.manager.dao.config.MyMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 系统配置信息
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年12月4日 下午6:46:16
 */
public interface SysConfigMapper extends MyMapper<SysConfigEntity> {

    /**
     * 根据key，查询value
     */
    String queryByKey(String paramKey);

    /**
     * 根据key，更新value
     *
     * @param key
     * @param value
     * @return
     */
    int updateValueByKey(@Param("key") String key, @Param("value") String value);

}
