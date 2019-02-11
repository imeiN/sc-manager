package com.mtgz.sc.manager.web.compoent.redisson;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by linyisheng on 2019/1/19.
 */
public class RedissonService {

    @Autowired
    private RedissonClient redissonClient;


}
