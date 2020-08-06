package com.skotori.sunzboot.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.skotori.sunzboot.common.log.Log;
import com.skotori.sunzboot.common.result.Result;
import com.skotori.sunzboot.common.shiro.ShiroFactory;
import com.skotori.sunzboot.common.shiro.ShiroUser;
import com.skotori.sunzboot.common.utils.HttpUtil;
import com.skotori.sunzboot.module.sys.entity.SysUser;
import com.skotori.sunzboot.module.sys.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.skotori.sunzboot.common.log.LogTypeEnum.OPERATE_LOG;

/**
 * 系统用户controller
 * @author skotori
 * @date 2019/11/06 20:35
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    private static final Logger log = LoggerFactory.getLogger(SysUserController.class);

    @Resource
    private SysUserService sysUserService;

    /**
     * 查询登录用户信息
     * @return
     */
    @GetMapping("userInfo")
    @Log(msg = "查询登录用户信息", type = OPERATE_LOG)
    public Result userInfo() {
        log.info("查询登录用户信息");
        ShiroFactory shiroFactory = ShiroFactory.getShiroFactory();
        SysUser user = shiroFactory.getUser(HttpUtil.getAccount());
        ShiroUser shiroUser = shiroFactory.getShiroUser(user);
        log.info("查询登录用户信息成功");
        return Result.success(shiroUser);
    }


    /**
     * 分页查询用户列表
     * @param pageNum
     * @param pageSize
     * @param user
     * @return
     */
    @PostMapping("pageList")
    @Log(msg = "分页查询用户列表", type = OPERATE_LOG)
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestBody SysUser user) {
        log.info("分页查询用户列表，param参数pageNum：[ {} ]，param参数pageSize：[ {} ]，body参数user：[ {} ]", pageNum, pageSize, user);
        PageInfo<SysUser> pageInfo = sysUserService.pageList(pageNum, pageSize, user);
        log.info("分页查询用户列表成功");
        return Result.success(pageInfo);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("add")
    @Log(msg = "新增用户", type = OPERATE_LOG)
    public Result add(@RequestBody SysUser user) {
        log.info("新增用户，body参数user：[ {} ]", user);
        sysUserService.add(user);
        log.info("新增用户成功");
        return Result.success();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("delete")
    @Log(msg = "删除用户", type = OPERATE_LOG)
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除用户，param参数id：[ {} ]", id);
        sysUserService.delete(id);
        log.info("删除用户成功");
        return Result.success();
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("update")
    @Log(msg = "更新用户", type = OPERATE_LOG)
    public Result update(@RequestBody SysUser user) {
        log.info("更新用户，body参数user：[ {} ]", user);
        sysUserService.update(user);
        log.info("更新用户成功");
        return Result.success();
    }

    /**
     * 通过用户id查询用户信息
     * @param id
     * @return
     */
    @GetMapping("userInfoById")
    @Log(msg = "通过用户id查询用户信息", type = OPERATE_LOG)
    public Result userInfoById(@RequestParam Integer id) {
        log.info("通过用户id查询用户信息");
        SysUser user = sysUserService.userInfoById(id);
        log.info("通过用户id查询用户信息成功");
        return Result.success(user);
    }

    /**
     * 重复账号检查
     * @param account
     * @return
     */
    @GetMapping("accountCheck")
    @Log(msg = "重复账号检查", type = OPERATE_LOG)
    public Result accountCheck(@RequestParam String account) {
        log.info("重复账号检查");
        Integer i = sysUserService.accountCheck(account);
        log.info("重复账号检查成功");
        return Result.success(i);
    }

}
