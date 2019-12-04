package com.skotori.sunzboot.common.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * EhCache缓存工厂类
 * @author skotori
 * @date 2019-11-29 17:15
 */
public class CacheFactory {

    private static CacheManager cacheManager;
    private static final Object locker = new Object();
    private static final Logger log = LoggerFactory.getLogger(CacheFactory.class);

    private static CacheManager getCacheManager() {
        if (cacheManager == null) {
            synchronized (CacheFactory.class) {
                if (cacheManager == null) {
                    cacheManager = CacheManager.create();
                }
            }
        }
        return cacheManager;
    }

    private static Cache getOrAddCache(String cacheName) {
        CacheManager cacheManager = getCacheManager();
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            synchronized(locker) {
                cache = cacheManager.getCache(cacheName);
                if (cache == null) {
                    log.warn("无法找到缓存[ {} ]的配置, 使用默认配置", cacheName);
                    cacheManager.addCacheIfAbsent(cacheName);
                    cache = cacheManager.getCache(cacheName);
                    log.info("缓存[ {} ]启动", cacheName);
                }
            }
        }
        return cache;
    }

    public void put(String cacheName, Object key, Object value) {
        getOrAddCache(cacheName).put(new Element(key, value));
    }

    public <T> T get(String cacheName, Object key) {
        Element element = getOrAddCache(cacheName).get(key);
        return element != null ? (T) element.getObjectValue() : null;
    }

    public List getKeys(String cacheName) {
        return getOrAddCache(cacheName).getKeys();
    }

    public void remove(String cacheName, Object key) {
        getOrAddCache(cacheName).remove(key);
    }

    public void removeAll(String cacheName) {
        getOrAddCache(cacheName).removeAll();
    }

}
