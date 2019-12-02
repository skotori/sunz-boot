package com.skotori.sunzboot.module.auth.controller;

import com.skotori.sunzboot.common.cache.CacheUtil;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.shiro.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author skotori
 * @date 2019-11-28 15:16
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("role")
    @RequiresRoles("admin")
    public Result role() {
        return Result.success();
    }

    @GetMapping("permission")
    @RequiresPermissions("hello")
    public Result permission() {
        return Result.success();
    }

    @GetMapping("cache")
    public Result cache() {
        String account = ShiroUtil.getAccount();
        CacheUtil.put("local", account, account);
        Object local = CacheUtil.get("local", account);
        System.out.println(local);
        CacheUtil.remove("local", account);
        Object local1 = CacheUtil.get("local", account);
        System.out.println(local1);
        return Result.success();
    }

    @GetMapping("cacheA")
    @Cacheable(value = "local", key = "#a")
    public Integer cacheA(Integer a) {
        System.out.println(a);
        return a;
    }

    @GetMapping("cacheP")
    @CachePut(value = "local", key = "#b")
    public Integer cacheP(Integer b) {
        System.out.println(b);
        return b;
    }

    @GetMapping("cacheE")
    @CacheEvict(value = "local", key = "#c")
    public Integer cacheE(Integer c) {
        System.out.println(c);
        return c;
    }

}
