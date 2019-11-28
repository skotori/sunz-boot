package com.skotori.sunzboot.module.sys.controller;

import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.shiro.ShiroUtil;
import com.skotori.sunzboot.module.sys.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger log = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("query")
    public Result query(@RequestParam("account") String account){
        log.info("测试接口");
        String account1 = ShiroUtil.getAccount();
        System.out.println(account1);
        return Result.success(sysUserService.queryUser(account));
    }

}
