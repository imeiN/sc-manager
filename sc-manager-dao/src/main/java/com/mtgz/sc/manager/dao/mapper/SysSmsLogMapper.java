package com.mtgz.sc.manager.dao.mapper;


import com.mtgz.sc.manager.common.entity.SysSmsLogEntity;
import com.mtgz.sc.manager.dao.config.MyMapper;

/**
 * 发送短信日志Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-12-16 23:38:05
 */
public interface SysSmsLogMapper extends MyMapper<SysSmsLogEntity> {

    int delete(String id);
}
