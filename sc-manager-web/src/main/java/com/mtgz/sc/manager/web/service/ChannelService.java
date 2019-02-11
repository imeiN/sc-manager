package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.dao.mapper.ChannelMapper;
import com.mtgz.sc.manager.dao.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-22 19:19:56
 */
@Service("channelService")
public class ChannelService {
    @Autowired
    private ChannelMapper channelMapper;


    public Channel queryObject(Integer id) {
        return channelMapper.queryObject(id);
    }


    public List<Channel> queryList(Map<String, Object> map) {
        return channelMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return channelMapper.queryTotal(map);
    }


    public int save(Channel channel) {
        return channelMapper.save(channel);
    }


    public int update(Channel channel) {
        return channelMapper.update(channel);
    }


    public int delete(Integer id) {
        return channelMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return channelMapper.deleteBatch(ids);
    }
}
