package com.skotori.sunzboot.common.cache;

import java.util.List;

/**
 * 缓存工具类
 * @author skotori
 * @date 2019-11-29 17:18
 */
public class CacheUtil {

    private static CacheFactory cacheFactory = new CacheFactory();

    public static void put(String cacheName, Object key, Object value) {
        cacheFactory.put(cacheName, key, value);
    }

    public static <T> T get(String cacheName, Object key) {
        return cacheFactory.get(cacheName, key);
    }

    public static List getKeys(String cacheName) {
        return cacheFactory.getKeys(cacheName);
    }

    public static void remove(String cacheName, Object key) {
        cacheFactory.remove(cacheName, key);
    }

    public static void removeAll(String cacheName) {
        cacheFactory.removeAll(cacheName);
    }

}
