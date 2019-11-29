package com.skotori.sunzboot.module.auth.controller;

import com.skotori.sunzboot.common.result.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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

}
