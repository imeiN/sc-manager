package com.mtgz.sc.manager.web.compoent;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CacheUtils {

    @Autowired
    private RedissonClient redissonClient;


    /**
     * 商城业务缓存
     */
    public static String SHOP_CACHE_NAME = "shopCache";
    /**
     * 系统缓存
     */
    private static String SYS_CACHE_NAME = "sysCache";

    /**
     * 获取SYS_CACHE_NAME缓存
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return get(SYS_CACHE_NAME, key);
    }

    /**
     * 写入SYS_CACHE_NAME缓存
     *
     * @param key
     * @return
     */
    public void put(String key, Object value) {
        put(SYS_CACHE_NAME, key, value);
    }

    /**
     * 从SYS_CACHE_NAME缓存中移除
     *
     * @param key
     * @return
     */
    public void remove(String key) {
        remove(SYS_CACHE_NAME, key);
    }

    /**
     * 获取缓存
     *
     * @param cacheName
     * @param key
     * @return
     */
    public Object get(String cacheName, String key) {

        return redissonClient.getBucket(cacheName+key).get();

    }

    /**
     * 写入缓存
     *
     * @param cacheName
     * @param key
     * @param value
     */
    public void put(String cacheName, String key, Object value) {
        redissonClient.getBucket(cacheName+key).set(value);
    }

    /**
     * 从缓存中移除
     *
     * @param cacheName
     * @param key
     */
    public void remove(String cacheName, String key) {
        redissonClient.getBucket(cacheName+key).delete();
    }

    /**
     * 获取SYS_CACHE缓存的所有key
     *
     * @return
     */
    public Collection<String> keys() {
        return redissonClient.getKeys().getKeysStream().collect(Collectors.toList());
    }
    /**
     * 获取缓存的所有key
     *
     * @param cacheName
     * @return
     */
    public Collection<String> keys(String cacheName) {
        return redissonClient.getKeys().getKeysStreamByPattern(cacheName).collect(Collectors.toList());
    }

    /**
     * Clear the cache
     *
     * @param cacheName: Cache region name
     */
    public void clear(String cacheName) {
        redissonClient.getBucket(cacheName).delete();
    }

//    /**
//     * 判断某个缓存键是否存在
//     *
//     * @param region Cache region name
//     * @param key    cache key
//     * @return true if key exists
//     */
//    public static boolean exists(String region, String key) {
//        return check(region, key) > 0;
//    }
//
//    /**
//     * 判断某个key存在于哪级的缓存中
//     *
//     * @param region cache region
//     * @param key    cache key
//     * @return 0(不存在), 1(一级), 2(二级)
//     */
//    public int check(String region, String key) {
//        return redissonClient(region, key);
//    }
}
