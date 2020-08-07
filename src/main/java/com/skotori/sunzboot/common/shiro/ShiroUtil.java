package com.skotori.sunzboot.common.shiro;

import javax.annotation.Resource;

/**
 * shiro工具类
 * @author skotori
 * @date 2019-11-15 10:33
 */
public class ShiroUtil {

    @Resource
    private static ShiroRealm shiroRealm;

    /**
     * 清楚shiro缓存
     * @return
     */
    public static void clearCached() {
        shiroRealm.clearCached();
    }

}
