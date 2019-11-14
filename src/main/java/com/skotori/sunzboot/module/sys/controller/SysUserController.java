package com.skotori.sunzboot.module.sys.controller;

import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.module.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员控制器
 * @author skotori
 * @date 2019/11/06 20:35
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("query")
    public Result query(@RequestParam("account") String account){
        return Result.success(sysUserService.queryUser(account));
    }

}
